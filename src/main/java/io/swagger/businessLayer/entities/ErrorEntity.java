package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@Getter @Setter
@Data
public class ErrorEntity {
    private String errorMessage;
}
