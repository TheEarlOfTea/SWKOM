package io.swagger.controller.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.services.ParcelService;
import io.swagger.services.dto.Parcel;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ApiOperation("Parcel API")
public class ParcelControllerImpl implements ParcelController{

    private final ParcelService parcelService;

    @Autowired
    public ParcelControllerImpl(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    //@Override
    public ResponseEntity<String> submitParcel(Parcel parcel) {
        return new ResponseEntity<String>("Successfully submitted parcel", HttpStatus.OK);
    }

    //@Override
    public ResponseEntity getParcelByTrackingId(@PathVariable("trackingId") @Parameter(example = "ABCD",description = "blabla")String trackingId) {
        Parcel parcel=parcelService.findByTrackingId(trackingId);
        if(parcel==null){
            return new ResponseEntity<String>("No parcel with given trackingId found", HttpStatus.OK);
        }
        return ResponseEntity.ok(parcel);
    }


}
