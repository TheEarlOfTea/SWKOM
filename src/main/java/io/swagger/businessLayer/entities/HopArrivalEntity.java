package io.swagger.businessLayer.entities;

import lombok.*;
import org.threeten.bp.OffsetDateTime;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data
public class HopArrivalEntity {

    private String code;
    private String description;
    private OffsetDateTime dateTime;
}
