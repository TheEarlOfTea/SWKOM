package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@Data
public class GeoCoordinateEntity {
    private long lat;
    private long lon;
}
