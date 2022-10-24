package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class GeoCoordinateBusinessEntity {
    private long lat;
    private long lon;
}
