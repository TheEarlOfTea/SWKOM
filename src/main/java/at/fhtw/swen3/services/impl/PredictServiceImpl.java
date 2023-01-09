package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.PredictService;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.WarehouseNotFoundException;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.mapper.GeoCoordinateMapper;
import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import org.wololo.geojson.GeoJSON;
import org.wololo.geojson.Geometry;
import org.wololo.geojson.Polygon;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class PredictServiceImpl implements PredictService {

    private final WarehouseRepository warehouseRepository;
    private final BingEncodingProxy bingEncodingProxy;
    private final HopRepository hopRepository;

    @Autowired
    public PredictServiceImpl(WarehouseRepository warehouseRepository, HopRepository hopRepository) {
        this.warehouseRepository = warehouseRepository;
        this.hopRepository = hopRepository;
        this.bingEncodingProxy= new BingEncodingProxy();
    }

    @Override
    public List<HopArrival> predict(Parcel parcel) throws WarehouseNotFoundException {

        RecipientEntity recipient = RecipientMapper.INSTANCE.fromDTO(parcel.getRecipient());
        RecipientEntity sender = RecipientMapper.INSTANCE.fromDTO(parcel.getSender());

        GeoCoordinate geoCoordinateSender = bingEncodingProxy.encodeAddress(Address.builder()
                .country(sender.getCountry())
                .city(sender.getCity())
                .street(sender.getStreet())
                .postalCode(sender.getPostalCode())
                .build());
        GeoCoordinate geoCoordinateRecipient = bingEncodingProxy.encodeAddress(Address.builder()
                .country(recipient.getCountry())
                .city(recipient.getCity())
                .street(recipient.getStreet())
                .postalCode(recipient.getPostalCode())
                .build());

        WarehouseEntity warehouseForSender =
                warehouseRepository.findByLocationCoordinates(geoCoordinateSender)
                        .orElseThrow(() -> new WarehouseNotFoundException("no warehouse found"));
        getHopByGeoCoordinate(geoCoordinateSender);

        WarehouseEntity warehouseForRecipient =
                warehouseRepository.findByLocationCoordinates(geoCoordinateRecipient).orElseThrow(() -> new WarehouseNotFoundException("no warehouse found"));
        getHopByGeoCoordinate(geoCoordinateRecipient);

        List<HopArrival> hopArrivals = new LinkedList<>();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        List<HopEntity> allNextHopsUntilGeoCoordinate = getAllNextHopsUntilGeoCoordinate(warehouseForSender, new GeoCoordinateEntity(warehouseForRecipient.getLocationCoordinates()));
        for (HopEntity hop : allNextHopsUntilGeoCoordinate) {
            HopArrival hopArrival = new HopArrival();
            hopArrival.setCode(hop.getCode());
            hopArrival.setDescription(hop.getDescription());
            hopArrival.setDateTime(offsetDateTime.plusMinutes(hop.getProcessingDelayMins()));
            hopArrivals.add(hopArrival);
        }
        return hopArrivals;

    }

    private List<HopEntity> getAllNextHopsUntilGeoCoordinate(WarehouseEntity warehouse, GeoCoordinateEntity geoCoordinate) {
        List<WarehouseNextHopsEntity> nextHops = warehouse.getNextHops();
        List<HopEntity> allNextHops = new LinkedList<>();
        if (warehouse.getLocationCoordinates().equals(geoCoordinate)) {
            return List.of(warehouse);
        }
        for (WarehouseNextHopsEntity nextHop : nextHops) {
            if (nextHop.getHop() instanceof WarehouseEntity) {
                allNextHops.addAll(getAllNextHopsUntilGeoCoordinate((WarehouseEntity) nextHop.getHop(), geoCoordinate));
            } else {
                allNextHops.add(nextHop.getHop());
            }
        }
        return allNextHops;
    }

    private HopEntity getHopByGeoCoordinate(GeoCoordinate geoCoordinate) {
        List<HopEntity> all = hopRepository.findAllTrucksAndTransfers();
        for (HopEntity hop : all) {
            if (hop instanceof TransferwarehouseEntity) {
                TransferwarehouseEntity transferwarehouseEntity = (TransferwarehouseEntity) hop;
                transferwarehouseEntity.getRegionGeoJson();
            }
            if (hop instanceof TruckEntity) {
                TruckEntity truckEntity = (TruckEntity) hop;

            }
        }
    }
}
