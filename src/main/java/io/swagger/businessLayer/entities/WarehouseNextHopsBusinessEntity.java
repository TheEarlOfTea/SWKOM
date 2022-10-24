package io.swagger.businessLayer.entities;

import io.swagger.services.dto.Hop;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class WarehouseNextHopsBusinessEntity {
    private Integer traveltimeMins;
    private Hop hop;
}
