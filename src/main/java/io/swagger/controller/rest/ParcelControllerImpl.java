package io.swagger.controller.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.services.dto.Parcel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation("Parcel API")
public class ParcelControllerImpl implements ParcelController{
    @Override
    public ResponseEntity<String> submitParcel(Parcel parcel) {
        return new ResponseEntity<String>("Successfully submitted parcel", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Parcel> getParcel(long id) {
        return null;
    }
}
