package at.fhtw.swen3.rest;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HierachyNotLoadedException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadWareHouseDataException;
import at.fhtw.swen3.services.EmailNotificationService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Warehouse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.geolatte.geom.V;
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

    private final WarehouseService warehouseService;
    private final EmailNotificationService emailNotificationService;


    public WarehouseApiController(ObjectMapper objectMapper, HttpServletRequest request, WarehouseService warehouseService, EmailNotificationService emailNotificationService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.warehouseService = warehouseService;
        this.emailNotificationService = emailNotificationService;
    }

    public ResponseEntity<Warehouse> exportWarehouses() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Warehouse>(warehouseService.exportWarehouses(), HttpStatus.OK);
            } catch(HierachyNotLoadedException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Warehouse>(HttpStatus.NOT_FOUND);
            }catch (Exception e){
                System.out.println("Something went wrong. Please contact your System Admin.");
                log.error(e.getMessage());
                emailNotificationService.sendEmail("Unexpected Error during Runtime in Parcel TNT", "Something went wrong while trying to export the warehouse hierachy.\n\nPlease check the logs for more info.");
                return new ResponseEntity<Warehouse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Warehouse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Hop> getWarehouse(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<>(warehouseService.getWarehouse(code), HttpStatus.OK) ;
            }catch (HopNotFoundException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Hop>(HttpStatus.NOT_FOUND);
            }catch (Exception e){
                System.out.println("Something went wrong. Please contact your System Admin.");
                log.error(e.getMessage());
                emailNotificationService.sendEmail("Unexpected Error during Runtime in Parcel TNT", "Something went wrong while trying to retrieve a specific Hop.\n\nPlease check the logs for more info.");
                return new ResponseEntity<Hop>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Hop>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> importWarehouses(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @RequestBody Warehouse body) {
        try{
            warehouseService.importWarehouse(body);
        }catch (BadWareHouseDataException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.out.println("Something went wrong. Please contact your System Admin.");
            log.error(e.getMessage());
            emailNotificationService.sendEmail("Unexpected Error during Runtime in Parcel TNT", "Something went wrong while trying to import a new warehouse hierachy.\n\nPlease check the logs for more info.");
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);

    }

}
