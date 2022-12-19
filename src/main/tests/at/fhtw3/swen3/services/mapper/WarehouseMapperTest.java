package at.fhtw3.swen3.services.mapper;

import at.fhtw3.swen3.persistence.entities.WarehouseEntity;
import at.fhtw3.swen3.services.dto.Warehouse;
import at.fhtw3.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseMapperTest {

    Warehouse warehouse= new Warehouse().level(1).nextHops(new LinkedList<WarehouseNextHops>());

    @Test
    void fromDTO() {
        warehouse.setDummyData();
        warehouse.addNextHopsItem(new WarehouseNextHops().traveltimeMins(3));
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

        warehouse.setDummyData();
        warehouse.addNextHopsItem(Mockito.mock(WarehouseNextHops.class));
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