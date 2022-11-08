package io.swagger.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.connector.impl.WarehouseConnector;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;
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
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")
@RestController
public class WarehouseApiController implements WarehouseApi {

    private static final Logger log = LoggerFactory.getLogger(WarehouseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final WarehouseConnector connector;

    @org.springframework.beans.factory.annotation.Autowired
    public WarehouseApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.connector= new WarehouseConnector();
    }

    public ResponseEntity<Warehouse> exportWarehouses() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Warehouse>(objectMapper.readValue("\"\"", Warehouse.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Warehouse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Warehouse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Hop> getWarehouse(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Hop hop = connector.getWarehouse(code);
                //return new ResponseEntity<Hop>(objectMapper.readValue("{\n  \"code\" : \"code\",\n  \"locationName\" : \"locationName\",\n  \"processingDelayMins\" : 0,\n  \"hopType\" : \"hopType\",\n  \"description\" : \"description\",\n  \"locationCoordinates\" : {\n    \"lon\" : 1.4658129805029452,\n    \"lat\" : 6.027456183070403\n  }\n}", Hop.class), HttpStatus.CREATED);
                return new ResponseEntity<Hop>(hop, HttpStatus.CREATED);
            }catch(ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<Hop>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Hop>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> importWarehouses(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Warehouse body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
               connector.importWarehouse(body);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}