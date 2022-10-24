package io.swagger.businessLayer.entities;

import io.swagger.services.dto.GeoCoordinate;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class HopEntity {
    private String hopType;
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    private GeoCoordinate locationCoordinates;
}
