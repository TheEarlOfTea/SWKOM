package io.swagger.businessLayer.entities;

import io.swagger.services.dto.WarehouseNextHops;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data
public class WarehouseEntity {
    private Integer level;
    private List<WarehouseNextHops> nextHops;
}
