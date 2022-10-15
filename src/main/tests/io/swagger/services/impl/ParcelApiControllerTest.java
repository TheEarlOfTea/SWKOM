package io.swagger.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.dto.Parcel;
import junit.framework.TestCase;
import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParcelApiControllerTest extends TestCase {

    public static ParcelApiController intialize() {


        HttpServletRequest request= mock(HttpServletRequest.class);
        when(request.getHeader("Accept")).thenReturn("application/json");

        controller = new ParcelApiController(mock(ObjectMapper.class), request);
        return controller;
    }

    static ParcelApiController controller= intialize();


    @Test
    public void testReportParcelDelivery() {
        ResponseEntity response= controller.reportParcelDelivery("12");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testReportParcelHop() {
        ResponseEntity response= controller.reportParcelHop("12", "23");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testSubmitParcel() {
        ResponseEntity response= controller.submitParcel(mock(Parcel.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testTrackParcel() {
        ResponseEntity response= controller.trackParcel("12");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    public void testTransitionParcel() {
        ResponseEntity response= controller.transitionParcel("12", mock(Parcel.class));
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}