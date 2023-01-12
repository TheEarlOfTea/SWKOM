package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.PredictService;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PredictServiceImpl implements PredictService {

    private final BingEncodingProxy bingEncodingProxy;
    private final HopRepository hopRepository;
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Autowired
    public PredictServiceImpl(HopRepository hopRepository, WarehouseNextHopsRepository warehouseNextHopsRepository) {
        this.hopRepository = hopRepository;
        this.bingEncodingProxy= new BingEncodingProxy();
        this.warehouseNextHopsRepository = warehouseNextHopsRepository;
    }

    @Override
    @Transactional
    public List<HopArrival> predict(Parcel parcel) throws BadAddressException {
        /*

        RecipientEntity recipient = RecipientMapper.INSTANCE.fromDTO(parcel.getRecipient());
        RecipientEntity sender = RecipientMapper.INSTANCE.fromDTO(parcel.getSender());

        return buildRoad(
                    getHopByGeoCoordinate(bingEncodingProxy.encodeAddress(Address.builder()
                            .country(sender.getCountry())
                            .city(sender.getCity())
                            .street(sender.getStreet())
                            .postalCode(sender.getPostalCode())
                            .build())),
                    getHopByGeoCoordinate(bingEncodingProxy.encodeAddress(Address.builder()
                            .country(recipient.getCountry())
                            .city(recipient.getCity())
                            .street(recipient.getStreet())
                            .postalCode(recipient.getPostalCode())
                            .build())))
                .stream()
                .map(HopArrivalMapper.INSTANCE::fromEntity)
                .collect(Collectors.toList());

                */
        return  new ArrayList<HopArrival>();
    }
/*
    private List<HopArrivalEntity> buildRoad(HopEntity senderHop, HopEntity recipientHop) {
        List<HopArrivalEntity> hopArrivals = new LinkedList<>();

        // add start
        hopArrivals.add(createArrival(senderHop, OffsetDateTime.now()));

        // find road
        findCommonMotherWarehouseAndBuildRoad(hopArrivals, senderHop, recipientHop);

        //add finish
        hopArrivals.add(createArrival(recipientHop, hopArrivals.get(hopArrivals.size() - 1).getDateTime()));
        return hopArrivals;
    }

    private void findCommonMotherWarehouseAndBuildRoad(List<HopArrivalEntity> road, HopEntity senderHop, HopEntity recipientHop) {
        WarehouseEntity senderMotherWarehouse = warehouseNextHopsRepository.findByHopId(senderHop.getId())
                .orElseThrow(() -> new HopNotFoundException(""))
                .getWarehouse();

        WarehouseEntity recipientMotherWarehouse = warehouseNextHopsRepository.findByHopId(recipientHop.getId())
                .orElseThrow(() -> new HopNotFoundException(""))
                .getWarehouse();

        if (senderMotherWarehouse.getLevel() > recipientMotherWarehouse.getLevel()) {
            road.add(createArrival(recipientMotherWarehouse, road.get(road.size() - 1).getDateTime()));

            findCommonMotherWarehouseAndBuildRoad(road,
                    warehouseNextHopsRepository.findByHopId(recipientMotherWarehouse.getId())
                            .orElseThrow(() -> new HopNotFoundException(""))
                            .getWarehouse(),
                    recipientHop);

        } else if (senderMotherWarehouse.getLevel() < recipientMotherWarehouse.getLevel()) {
            road.add(createArrival(senderMotherWarehouse, road.get(road.size() - 1).getDateTime()));

            findCommonMotherWarehouseAndBuildRoad(road,
                    warehouseNextHopsRepository.findByHopId(senderMotherWarehouse.getId())
                        .orElseThrow(() -> new HopNotFoundException(""))
                        .getWarehouse(),
                    recipientHop);

        } else {
            road.add(createArrival(senderMotherWarehouse, road.get(road.size() - 1).getDateTime()));
        }
    }

    private HopArrivalEntity createArrival(HopEntity hop, OffsetDateTime offsetDateTime) {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode(hop.getCode());
        hopArrivalEntity.setDescription(hop.getDescription());
        hopArrivalEntity.setDateTime(offsetDateTime.plusMinutes(hop.getProcessingDelayMins()));
        return hopArrivalEntity;
    }

    private HopEntity getHopByGeoCoordinate(GeoCoordinate geoCoordinate) throws BadAddressException {
        List<HopEntity> all = hopRepository.findAllTrucksAndTransfers();
        for (HopEntity hop : all) {
            if (hop instanceof TransferwarehouseEntity) {
                TransferwarehouseEntity transferwarehouseEntity = (TransferwarehouseEntity) hop;
                if (transferwarehouseEntity.getRegionGeoJson().contains(new GeometryFactory().createPoint(new Coordinate(geoCoordinate.getLon(), geoCoordinate.getLat())))) {
                    return hop;
                }
            }
            if (hop instanceof TruckEntity) {
                TruckEntity truckEntity = (TruckEntity) hop;
                if (truckEntity.getRegionGeoJson().contains(new GeometryFactory().createPoint(new Coordinate(geoCoordinate.getLon(), geoCoordinate.getLat())))) {
                    return hop;
                }
            }
        }
        throw new BadAddressException("No hop for given address could be found");
    }*/
}
