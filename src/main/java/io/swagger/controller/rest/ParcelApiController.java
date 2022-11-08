package io.swagger.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.connector.impl.ParcelConnector;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Pattern;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")
@RestController

public class ParcelApiController implements ParcelApi {

    private static final Logger log = LoggerFactory.getLogger(ParcelApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ParcelConnector connector;

    @org.springframework.beans.factory.annotation.Autowired
    public ParcelApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.connector= new ParcelConnector();
    }

    public ResponseEntity<Void> reportParcelDelivery(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                connector.reportParcelDelivery(trackingId);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> reportParcelHop(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Pattern(regexp="^[A-Z]{4}\\d{1,4}$") @Parameter(in = ParameterIn.PATH, description = "The Code of the hop (Warehouse or Truck).", required=true, schema=@Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                connector.reportParcelHop(trackingId, code);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<NewParcelInfo> submitParcel(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                connector.submitParcel(body);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            try{
                return new ResponseEntity<NewParcelInfo>(objectMapper.readValue("{\n  \"trackingId\" : \"PYJRB4HZ6\"\n}", NewParcelInfo.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
            }
        }
        return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrackingInformation> trackParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                connector.trackParcel(trackingId);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<TrackingInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            try {
                return new ResponseEntity<TrackingInformation>(objectMapper.readValue("{\n  \"visitedHops\" : [ {\n    \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"code\" : \"code\",\n    \"description\" : \"description\"\n  }, {\n    \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"code\" : \"code\",\n    \"description\" : \"description\"\n  } ],\n  \"futureHops\" : [ null, null ],\n  \"state\" : \"Pickup\"\n}", TrackingInformation.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);

            }
            return new ResponseEntity<TrackingInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<TrackingInformation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<NewParcelInfo> transitionParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                connector.submitTransitionParcel(trackingId, body);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            try {
                return new ResponseEntity<NewParcelInfo>(objectMapper.readValue("{\n  \"trackingId\" : \"PYJRB4HZ6\"\n}", NewParcelInfo.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
            }
        }
        return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_IMPLEMENTED);
    }

}