package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BingEncodingProxyTest {

    @Autowired
    BingEncodingProxy proxy;

    String city= "Wien";
    String country="Österreich";
    String postalCode= "1200";
    String street="Höchstädtplatz 6";

    @Test
    void encodeAddress() {
        Address address= new Address(street, postalCode, city, country);
        System.out.println(proxy.encodeAddress(address));
    }
}