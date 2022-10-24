package io.swagger.businessLayer.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data
public class GeoCoordinateEntity {
    private long lat;
    private long lon;
}
