package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseMapperTest {

    @Test
    void testFromDTO() {

        Warehouse warehouse= new Warehouse().level(1).nextHops(new LinkedList<WarehouseNextHops>());
        warehouse.setDummyData();

        Truck truck= new Truck();
        truck.setDummyData();
        truck.setCode("TRUCK");
        truck.setNumberPlate("abc");
        truck.setRegionGeoJson("abc");

        warehouse.addNextHopsItem(new WarehouseNextHops().traveltimeMins(3).hop(truck));

        WarehouseEntity entity= WarehouseMapper.INSTANCE.fromDTO(warehouse);
        assertEquals(warehouse.getCode(), entity.getCode());
        assertEquals(warehouse.getDescription(), entity.getDescription());
        assertEquals(warehouse.getHopType(), entity.getHopType());
        assert(warehouse.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert(warehouse.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());
        assertEquals(warehouse.getLocationName(), entity.getLocationName());
        assertEquals(warehouse.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(warehouse.getLevel(), entity.getLevel());
        assertEquals(warehouse.getNextHops().get(0), WarehouseNextHopMapper.INSTANCE.fromEntity(entity.getNextHops().get(0)));
    }

    @Test
    void fromEntity() {

        Warehouse warehouse= new Warehouse().level(1).nextHops(new LinkedList<WarehouseNextHops>());
        warehouse.setDummyData();

        Truck truck= new Truck();
        truck.setDummyData();
        truck.setCode("TRUCK");
        truck.setNumberPlate("abc");
        truck.setRegionGeoJson("abc");

        warehouse.addNextHopsItem(new WarehouseNextHops().traveltimeMins(3).hop(truck));

        WarehouseEntity entity= WarehouseMapper.INSTANCE.fromDTO(warehouse);
        Warehouse newWarehouse= WarehouseMapper.INSTANCE.fromEntity(entity);

        assertEquals(entity.getCode(), newWarehouse.getCode());
        assertEquals(entity.getDescription(), newWarehouse.getDescription());
        assertEquals(entity.getHopType(), newWarehouse.getHopType());
        assert(entity.getLocationCoordinates().getX() == newWarehouse.getLocationCoordinates().getLon());
        assert(entity.getLocationCoordinates().getY() == newWarehouse.getLocationCoordinates().getLat());
        assertEquals(entity.getLocationName(), newWarehouse.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newWarehouse.getProcessingDelayMins());
        assertEquals(entity.getLevel(), newWarehouse.getLevel());
        assertEquals(WarehouseNextHopMapper.INSTANCE.fromEntity(entity.getNextHops().get(0)), newWarehouse.getNextHops().get(0));
    }
}