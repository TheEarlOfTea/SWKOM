package io.swagger.controller.rest;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.services.dto.Parcel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ParcelController {
    @ApiOperation(value = "Submit a new Parcel", notes = "Adds Parcel to the Database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Parcel successfully submited"),
            @ApiResponse(code = 400, message = "Error - Bad Parcel Body")
    })
    @PostMapping("/parcel")
    public ResponseEntity<String> submitParcel(@RequestBody Parcel parcel);

    @GetMapping("/parcel/{id}")
    public ResponseEntity<Parcel> getParcel(@PathVariable long id);
}
