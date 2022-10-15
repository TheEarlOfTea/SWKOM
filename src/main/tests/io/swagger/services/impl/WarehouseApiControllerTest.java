package io.swagger.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Warehouse;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WarehouseApiControllerTest extends TestCase {

    public static WarehouseApiController intialize() {


        HttpServletRequest request= mock(HttpServletRequest.class);
        when(request.getHeader("Accept")).thenReturn("application/json");

        controller = new WarehouseApiController(mock(ObjectMapper.class), request);
        return controller;
    }

    static WarehouseApiController controller= intialize();

    @Test
    public void testExportWarehouses() {
        ResponseEntity response= controller.exportWarehouses();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testGetWarehouse() {
        ResponseEntity response= controller.getWarehouse("12");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testImportWarehouses() {
        ResponseEntity response= controller.importWarehouses(Mockito.mock(Warehouse.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}