package io.swagger.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.controller.rest.WarehouseApiController;
import io.swagger.services.dto.Warehouse;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WarehouseApiControllerTest extends TestCase {

    Warehouse warehouse;
    WarehouseApiController controller;
    WarehouseApiController controllerWithBadRequest;
    ResponseEntity response;

    public void intialize() {


        HttpServletRequest request= mock(HttpServletRequest.class);
        when(request.getHeader("Accept")).thenReturn("application/json");

        controller = new WarehouseApiController(mock(ObjectMapper.class), request);
        controllerWithBadRequest= new WarehouseApiController(mock(ObjectMapper.class), Mockito.mock(HttpServletRequest.class));

        warehouse= new Warehouse();
        warehouse.setDummyData();
    }

    @Test
    public void testExportWarehouses() {
        intialize();
        response= controller.exportWarehouses();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controllerWithBadRequest.exportWarehouses();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());

    }
    @Test
    public void testGetWarehouse() {
        intialize();
        response= controller.getWarehouse("ABCD12");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.getWarehouse("12");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        response=controllerWithBadRequest.getWarehouse("ABCD12");
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }
    @Test
    public void testImportWarehouses() {
        intialize();
        response= controller.importWarehouses(warehouse);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.importWarehouses(Mockito.mock(Warehouse.class));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        response= controllerWithBadRequest.importWarehouses(warehouse);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }
}