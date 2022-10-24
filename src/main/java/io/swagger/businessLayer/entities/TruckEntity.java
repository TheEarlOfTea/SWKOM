package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@Data

public class TruckEntity extends HopEntity{
    private String regionGeoJson;
    private String numberPlate;
}
