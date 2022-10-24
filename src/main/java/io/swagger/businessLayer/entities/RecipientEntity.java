package io.swagger.businessLayer.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter @Setter
@Data
public class RecipientEntity {
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
