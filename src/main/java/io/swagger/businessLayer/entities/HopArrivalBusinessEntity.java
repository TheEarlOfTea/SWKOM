package io.swagger.businessLayer.entities;

import lombok.*;
import org.threeten.bp.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class HopArrivalBusinessEntity {

    private String code;
    private String description;
    private OffsetDateTime dateTime;
}
