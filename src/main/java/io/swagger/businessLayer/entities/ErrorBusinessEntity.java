package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class ErrorBusinessEntity {
    private String errorMessage;
}