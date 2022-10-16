package io.swagger.businessLayer.connector.impl;

import io.swagger.model.GeoCoordinate;
import io.swagger.model.WarehouseNextHops;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import javax.validation.ValidationException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class WarehouseConnectorTest extends TestCase {

    Warehouse goodWarehouse;
    Warehouse badWarehouse;
    String goodCode;
    String badCode;

    WarehouseConnector connector;

    public void intialize() {

        connector=new WarehouseConnector();

        goodWarehouse= new Warehouse();
        goodWarehouse.setCode("ABCD1");
        goodWarehouse.setLevel(1);
        ArrayList<WarehouseNextHops> list= new ArrayList<WarehouseNextHops>();
        list.add(mock(WarehouseNextHops.class));
        goodWarehouse.setNextHops(list);
        goodWarehouse.setDescription("ABCD");
        goodWarehouse.setHopType("ABCD");
        goodWarehouse.setLocationCoordinates(mock(GeoCoordinate.class));
        goodWarehouse.setLocationName("ABCD");
        goodWarehouse.setProcessingDelayMins(1);

        badWarehouse= Mockito.mock(Warehouse.class);

        goodCode="ABCD1";
        badCode="A";
    }

    public void testGetWarehouse() {
        intialize();
        assertEquals(Hop.class, connector.getWarehouse(goodCode).getClass());
        assertThrows(ValidationException.class, () -> connector.getWarehouse(badCode));
    }

    public void testImportWarehouse() {
        intialize();
        assert(connector.importWarehouse(goodWarehouse));
        assertFalse(connector.importWarehouse(badWarehouse));
    }
}