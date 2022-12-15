package at.fhtw.swen3.rest;

import at.fhtw.swen3.services.HopService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

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

    private final HopService hopService;


    @Autowired
    public WarehouseApiController(ObjectMapper objectMapper, HttpServletRequest request, HopService hopService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.hopService= hopService;
    }

    public ResponseEntity<Warehouse> exportWarehouses() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Warehouse>(objectMapper.readValue("\"\"", Warehouse.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Warehouse>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Warehouse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Hop> getWarehouse(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<>(hopService.getWarehouse(code), HttpStatus.OK) ;
            }catch (HttpClientErrorException e){
                log.error("HttpClientErrorException exception: " + e.getMessage());
                return new ResponseEntity<Hop>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<Hop>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> importWarehouses(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Warehouse body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                hopService.importWarehouse(body);
            }catch (ValidationException e){
                log.error("Validation exception: " + e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }catch (HttpClientErrorException e){
                log.error("HttpClientErrorException exception: " + e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
