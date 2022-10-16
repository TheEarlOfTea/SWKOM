package io.swagger.businessLayer.validation;

import io.swagger.mapper.WarehouseMapper;
import io.swagger.model.GeoCoordinate;
import io.swagger.model.WarehouseNextHops;
import io.swagger.persistence.entity.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.ArrayList;

public class WarehouseValidatorTest extends TestCase {

    WarehouseEntity entity;

    void initialize(){
        Warehouse warehouse= new Warehouse();
        warehouse= new Warehouse();
        warehouse.setCode("ABCD1");
        warehouse.setLevel(1);
        ArrayList<WarehouseNextHops> list= new ArrayList<WarehouseNextHops>();
        list.add(Mockito.mock(WarehouseNextHops.class));
        warehouse.setNextHops(list);
        warehouse.setDescription("ABCD");
        warehouse.setHopType("ABCD");
        warehouse.setLocationCoordinates(Mockito.mock(GeoCoordinate.class));
        warehouse.setLocationName("ABCD");
        warehouse.setProcessingDelayMins(1);
        entity= WarehouseMapper.INSTANCE.from(warehouse);
    }

    public void testValidateWarehouse() {
        initialize();
        assert(WarehouseValidator.validateWarehouse(entity));
        assertFalse(WarehouseValidator.validateWarehouse(Mockito.mock(WarehouseEntity.class)));
    }
}