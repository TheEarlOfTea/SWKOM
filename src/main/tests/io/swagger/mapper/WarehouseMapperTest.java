package io.swagger.mapper;

import io.swagger.model.GeoCoordinate;
import io.swagger.model.HopArrival;
import io.swagger.model.WarehouseNextHops;
import io.swagger.persistence.entity.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WarehouseMapperTest extends TestCase {

    Warehouse warehouse;

    void initialize(){
        warehouse= new Warehouse();
        warehouse.setCode("1");
        warehouse.setLevel(1);
        ArrayList<WarehouseNextHops> list= new ArrayList<WarehouseNextHops>();
        list.add(Mockito.mock(WarehouseNextHops.class));
        warehouse.setNextHops(list);
        warehouse.setDescription("description");
        warehouse.setHopType("hoptype");
        warehouse.setLocationCoordinates(Mockito.mock(GeoCoordinate.class));
        warehouse.setLocationName("locationname");
        warehouse.setProcessingDelayMins(1);
    }

    public void testFrom() {
        initialize();
        WarehouseEntity entity= WarehouseMapper.INSTANCE.from(warehouse);
        assertEquals(warehouse.getLevel().intValue(), entity.getLevel());
        assertEquals(warehouse.getNextHops(), entity.getNextHops());
        assertEquals(warehouse.getCode(), entity.getCode());
        assertEquals(warehouse.getDescription(), entity.getDescription());
        assertEquals(warehouse.getHopType(), entity.getHopType());
        assertEquals(warehouse.getLocationCoordinates(), entity.getLocationCoordinates());
        assertEquals(warehouse.getLocationName(), entity.getLocationName());
        assertEquals(warehouse.getProcessingDelayMins(), entity.getProcessingDelayMins());
    }
}