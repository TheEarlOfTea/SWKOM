package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.PredictionService;
import at.fhtw.swen3.services.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class PredictionServiceImpl implements PredictionService {

    private final HopRepository hopRepository;
    private final WarehouseRepository warehouseRepository;
    private final BingEncodingProxy bingEncodingProxy;

    public PredictionServiceImpl(HopRepository hopRepository, WarehouseRepository warehouseRepository) {
        this.hopRepository = hopRepository;
        this.warehouseRepository = warehouseRepository;
        bingEncodingProxy= new BingEncodingProxy();
    }

    @Transactional
    public TrackingInformation getTrackingInformation(Recipient sender, Recipient recipient) throws BadAddressException {
        List<HopArrival> futureHops;
        GeoCoordinate senderCoordinate;
        GeoCoordinate recipientcoordinate;

        try{
            senderCoordinate= bingEncodingProxy.encodeAddress(Address.builder().city(sender.getCity()).country(sender.getCountry()).postalCode(sender.getPostalCode()).street(sender.getStreet()).build());
        }catch (BadAddressException e){
            log.error("Received Invalid Address for Sender. Exception: " + e.getMessage());
            throw e;
        }
        try{
            recipientcoordinate= bingEncodingProxy.encodeAddress(Address.builder().city(recipient.getCity()).country(recipient.getCountry()).postalCode(recipient.getPostalCode()).street(recipient.getStreet()).build());
        }catch (BadAddressException e){
            log.error("Received Invalid Address for Recipient. Exception: " + e.getMessage());
            throw e;
        }


        futureHops= getHopArrivalPath(senderCoordinate, recipientcoordinate);

        LinkedList<HopArrival> visitedHops= new LinkedList<HopArrival>();
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }

    @Transactional
    public List<HopArrival> getHopArrivalPath(GeoCoordinate senderCoordinate, GeoCoordinate recipientcoordinate) {
       List<WarehouseEntity> warehouseList= warehouseRepository.findByLevel(1);
       WarehouseEntity closestToSender= getClosestWarehouse(senderCoordinate, warehouseList);
       WarehouseEntity closestToRecipient= getClosestWarehouse(recipientcoordinate, warehouseList);

       WarehouseEntity rootWarehouse= warehouseRepository.findByLevel(0).get(0);

       List<HopArrival> hopArrivalList= getPathFromLowestToHighestLevel(closestToSender, rootWarehouse);
       List<HopArrival> pathFromRecipientToRoot= getPathFromLowestToHighestLevel(closestToRecipient, rootWarehouse);
       pathFromRecipientToRoot.remove(pathFromRecipientToRoot.size()-1);
       while(!pathFromRecipientToRoot.isEmpty()){
           hopArrivalList.add(pathFromRecipientToRoot.remove(pathFromRecipientToRoot.size()-1));
       }

       return hopArrivalList;

    }

    @Transactional
    public List<HopArrival> getPathFromLowestToHighestLevel(WarehouseEntity requestedWarehouse, WarehouseEntity currentWarehouse){
        List<HopArrival> list;
        if(currentWarehouse== requestedWarehouse){
            list= new LinkedList<HopArrival>();
            list.add(new HopArrival().code(currentWarehouse.getNextHops().get(0).getHop().getCode()).dateTime(OffsetDateTime.now()).description(currentWarehouse.getNextHops().get(0).getHop().getDescription()));
            list.add(new HopArrival().code(currentWarehouse.getCode()).description(currentWarehouse.getDescription()).dateTime(OffsetDateTime.now()));
            return list;
        }
        for (WarehouseNextHopsEntity e : currentWarehouse.getNextHops()){
            if(e.getHop().getHopType().equals("warehouse")) {
                list = getPathFromLowestToHighestLevel(requestedWarehouse, (WarehouseEntity)(e.getHop()));
                if (list != null) {
                    list.add(new HopArrival().code(currentWarehouse.getCode()).dateTime(OffsetDateTime.now()).description(currentWarehouse.getDescription()));
                    return list;
                }
            }
        }
        return null;
    }

    private WarehouseEntity getClosestWarehouse(GeoCoordinate geoCoordinate, List<WarehouseEntity> list){

        WarehouseEntity closestWarehouse= list.get(0);

        Point sourcePoint= new Point(geoCoordinate.getLat(), geoCoordinate.getLon());
        Point destinationPoint= new Point(closestWarehouse.getLocationCoordinates().getX(), closestWarehouse.getLocationCoordinates().getY());
        double distance= getDistance(sourcePoint, destinationPoint);
        double newDistance;

        for(WarehouseEntity e: list){
            destinationPoint=new Point(e.getLocationCoordinates().getX(), e.getLocationCoordinates().getY());
            newDistance= getDistance(sourcePoint, destinationPoint);
            if(newDistance<distance){
                distance= newDistance;
                closestWarehouse= e;
            }
        }

        return closestWarehouse;

    }

    private double getDistance(Point a, Point b){
        return Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
    }
}
