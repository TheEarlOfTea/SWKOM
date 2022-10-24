package io.swagger.businessLayer.entities;

import io.swagger.services.dto.WarehouseNextHops;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class WarehouseBusinessEntity extends HopBusinessEntity {
    private Integer level;
    private List<WarehouseNextHops> nextHops;
}
