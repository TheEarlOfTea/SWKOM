package at.fhtw.swen3.rest;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.ParcelNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.*;
import at.fhtw.swen3.services.EmailNotificationService;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
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
import javax.validation.constraints.Pattern;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")
@RestController

public class ParcelApiController implements ParcelApi {

    private static final Logger log = LoggerFactory.getLogger(ParcelApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ParcelService parcelService;
    private final EmailNotificationService emailNotificationService;


    public ParcelApiController(ObjectMapper objectMapper, HttpServletRequest request, ParcelService parcelService, EmailNotificationService emailNotificationService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.parcelService = parcelService;
        this.emailNotificationService = emailNotificationService;
    }

    public ResponseEntity<Void> reportParcelDelivery(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId) {
            try{
                parcelService.reportParcelDelivery(trackingId);
                return new ResponseEntity<Void>(HttpStatus.OK);
            }catch (BadTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }catch (FutureHopsIsNotEmptyException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }catch (ParcelNotFoundException e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

    }

    public ResponseEntity<Void> reportParcelHop(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Pattern(regexp="^[A-Z]{4}\\d{1,4}$") @Parameter(in = ParameterIn.PATH, description = "The Code of the hop (Warehouse or Truck).", required=true, schema=@Schema()) @PathVariable("code") String code) {
            try{
                parcelService.reportParcelHop(trackingId, code);
                return new ResponseEntity<Void>(HttpStatus.CREATED);
            }catch (BadTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }catch (ParcelNotFoundException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }catch (HopNotFoundException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
            }

    }

    public ResponseEntity<NewParcelInfo> submitParcel(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body) {
        String accept = request.getHeader("Accept");
        emailNotificationService.sendEmail("julian.weghaupt@gmail.com", "test", "test");
        if (accept != null && accept.contains("application/json")) {
            try {
                NewParcelInfo newParcelInfo = parcelService.saveDomesticParcel(body);
                return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.CREATED);
            }catch (BadParcelDataException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
            }catch (BadAddressException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_FOUND);
            }catch (DuplicateTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TrackingInformation> trackParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema(), example = "ABCD12345") @PathVariable("trackingId") String trackingId) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                TrackingInformation trackingInformation = parcelService.trackParcel(trackingId);
                return new ResponseEntity<TrackingInformation>(trackingInformation, HttpStatus.OK);
            }catch (BadTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<TrackingInformation>(HttpStatus.BAD_REQUEST);
            }catch (ParcelNotFoundException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<TrackingInformation>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<TrackingInformation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<NewParcelInfo> transitionParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try{
                NewParcelInfo newParcelInfo=parcelService.saveTransitionParcel(trackingId, body);
                return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.CREATED);
            }catch (BadParcelDataException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
            }catch (BadTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.BAD_REQUEST);
            }catch (BadAddressException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_FOUND);
            }catch (DuplicateTrackingIdException e){
                System.out.println(e.getMessage());
                return new ResponseEntity<NewParcelInfo>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<NewParcelInfo>(HttpStatus.NOT_IMPLEMENTED);
    }

}
