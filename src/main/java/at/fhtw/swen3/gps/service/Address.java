package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.services.dto.Recipient;
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

    public Address (Recipient recipient){
        this.city= recipient.getCity();
        this.country=recipient.getCountry();
        this.postalCode=recipient.getPostalCode();
        this.street=recipient.getStreet();
    }

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
