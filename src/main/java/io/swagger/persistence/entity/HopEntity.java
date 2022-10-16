package io.swagger.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import io.swagger.model.GeoCoordinate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class HopEntity {
    @NotNull
    private String hopType;
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$", message = "has to match \'^[A-Z]{4}\\d{1,4}$\'")
    @NotNull(message = "trackingId may not be null")
    private String code;
    @Pattern(regexp="^[A-Z0-9\\- ]*", message="has to match \'^[A-Z0-9\\- ]*\'")
    private String description;
    @Min(0)
    private Integer processingDelayMins;
    @Pattern(regexp="^[A-Z0-9\\- ]*", message="has to match \'^[A-Z0-9\\- ]*\'")
    private String locationName;
    @NotNull
    private GeoCoordinate locationCoordinates;

    public String getHopType() {
        return hopType;
    }

    public void setHopType(String hopType) {
        this.hopType = hopType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProcessingDelayMins() {
        return processingDelayMins;
    }

    public void setProcessingDelayMins(Integer processingDelayMins) {
        this.processingDelayMins = processingDelayMins;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public GeoCoordinate getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(GeoCoordinate locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }
}
