package io.swagger.businessLayer.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data
public class ErrorEntity {
    private String errorMessage;
}
