package io.swagger.connector.impl;

import io.swagger.connector.impl.WarehouseConnector;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WarehouseConnectorTest extends TestCase {

    Warehouse goodWarehouse;
    Warehouse badWarehouse;
    String goodCode;
    String badCode;

    WarehouseConnector connector= new WarehouseConnector();;

    @Test
    public void testGetWarehouse() {
        goodCode="ABCD1";
        badCode="A";
        assertEquals(Hop.class, connector.getWarehouse(goodCode).getClass());
        assertThrows(ValidationException.class, () -> connector.getWarehouse(badCode));
    }
    @Test
    public void testImportWarehouse() {
        goodWarehouse= new Warehouse();
        goodWarehouse.setDummyData();
        badWarehouse= Mockito.mock(Warehouse.class);
        assertDoesNotThrow(() -> connector.importWarehouse(goodWarehouse));
        assertThrows(ValidationException.class, () -> connector.importWarehouse(badWarehouse));
    }
}