package io.swagger.businessLayer.entities;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data
public class RecipientBusinessEntity {
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
