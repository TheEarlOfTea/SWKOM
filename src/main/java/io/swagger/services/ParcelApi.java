/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.services;

import io.swagger.services.dto.Error;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")
@Validated
public interface ParcelApi {

    @Operation(summary = "Report that a Parcel has been delivered at it's final destination address. ", description = "", tags={ "staff" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully reported hop."),
        
        @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID. ") })
    @RequestMapping(value = "/parcel/{trackingId}/reportDelivery/",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> reportParcelDelivery(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId);


    @Operation(summary = "Report that a Parcel has arrived at a certain hop either Warehouse or Truck. ", description = "", tags={ "staff" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully reported hop."),
        
        @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID or hop with code not found. ") })
    @RequestMapping(value = "/parcel/{trackingId}/reportHop/{code}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> reportParcelHop(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId, @Pattern(regexp="^[A-Z]{4}\\d{1,4}$") @Parameter(in = ParameterIn.PATH, description = "The Code of the hop (Warehouse or Truck).", required=true, schema=@Schema()) @PathVariable("code") String code);


    @Operation(summary = "Submit a new parcel to the logistics service. ", description = "", tags={ "sender" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Successfully submitted the new parcel", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewParcelInfo.class))),
        
        @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "The address of sender or receiver was not found.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/parcel",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<NewParcelInfo> submitParcel(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body);


    @Operation(summary = "Find the latest state of a parcel by its tracking ID. ", description = "", tags={ "recipient" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Parcel exists, here's the tracking information.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TrackingInformation.class))),
        
        @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "404", description = "Parcel does not exist with this tracking ID.") })
    @RequestMapping(value = "/parcel/{trackingId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<TrackingInformation> trackParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId);


    @Operation(summary = "Transfer an existing parcel into the system from the service of a logistics partner. ", description = "", tags={ "logisticsPartner" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully transitioned the parcel", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewParcelInfo.class))),
        
        @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
        
        @ApiResponse(responseCode = "409", description = "A parcel with the specified trackingID is already in the system.") })
    @RequestMapping(value = "/parcel/{trackingId}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<NewParcelInfo> transitionParcel(@Pattern(regexp="^[A-Z0-9]{9}$") @Parameter(in = ParameterIn.PATH, description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required=true, schema=@Schema()) @PathVariable("trackingId") String trackingId, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Parcel body);

}

