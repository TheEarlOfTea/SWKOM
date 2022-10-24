package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class TruckBusinessEntity extends HopBusinessEntity {
    private String regionGeoJson;
    private String numberPlate;
}
