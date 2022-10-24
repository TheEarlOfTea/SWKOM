package io.swagger.businessLayer.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.services.dto.Hop;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Data

public class WarehouseNextHopsEntity {
    private Integer traveltimeMins;
    private Hop hop;
}
