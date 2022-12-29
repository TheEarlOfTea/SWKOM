package io.swagger.gps.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String postalCode;
    private String city;
    private String country;
}
