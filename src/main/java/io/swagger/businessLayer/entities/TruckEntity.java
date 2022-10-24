package io.swagger.businessLayer.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data

public class TruckEntity extends HopEntity{
    private String regionGeoJson;
    private String numberPlate;
}
