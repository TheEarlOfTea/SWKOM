package io.swagger.businessLayer.entities;

import io.swagger.services.dto.WarehouseNextHops;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
@Data
public class WarehouseEntity extends HopEntity{
    private Integer level;
    private List<WarehouseNextHops> nextHops;
}
