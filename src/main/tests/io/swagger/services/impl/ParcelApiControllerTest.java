package io.swagger.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.Recipient;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParcelApiControllerTest extends TestCase {

    Parcel parcel;
    ParcelApiController controller;
    ParcelApiController controllerWithBadRequest;
    ResponseEntity response;

    public void intialize() {


        HttpServletRequest request= mock(HttpServletRequest.class);
        when(request.getHeader("Accept")).thenReturn("application/json");

        controller = new ParcelApiController(mock(ObjectMapper.class), request);
        controllerWithBadRequest= new ParcelApiController(mock(ObjectMapper.class), Mockito.mock(HttpServletRequest.class));
    }

    void initializeParcels(){
        parcel= new Parcel();
        parcel.setWeight(10.0f);
        Recipient testRecipient= new Recipient();
        testRecipient.setDummyData();
        parcel.setSender(testRecipient);
        parcel.setRecipient(testRecipient);
    }





    @Test
    public void testReportParcelDelivery() {
        intialize();
        response= controller.reportParcelDelivery("123456789");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.reportParcelDelivery("12789");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    public void testReportParcelHop() {
        intialize();
        response= controller.reportParcelHop("123456789", "ABCD1");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.reportParcelHop("12", "23");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    public void testSubmitParcel() {
        intialize();
        initializeParcels();
        response= controller.submitParcel(parcel);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.submitParcel(Mockito.mock(Parcel.class));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }
    @Test
    public void testTrackParcel() {
        intialize();
        response= controller.trackParcel("123456789");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.trackParcel("12");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    @Test
    public void testTransitionParcel() {
        intialize();
        initializeParcels();
        response= controller.transitionParcel("123456789", parcel);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        response= controller.transitionParcel("12", mock(Parcel.class));
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testWithBadRequest(){
        intialize();
        response= controllerWithBadRequest.submitParcel(Mockito.mock(Parcel.class));
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
        response= controllerWithBadRequest.reportParcelHop("1", "2");
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
        response= controllerWithBadRequest.transitionParcel("1", Mockito.mock(Parcel.class));
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
        response= controllerWithBadRequest.trackParcel("1");
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
        response= controllerWithBadRequest.reportParcelDelivery("1");
        assertEquals(HttpStatus.NOT_IMPLEMENTED, response.getStatusCode());
    }
}