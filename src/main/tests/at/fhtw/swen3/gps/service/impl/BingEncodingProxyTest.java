package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.services.dto.GeoCoordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class BingEncodingProxyTest {
    @Test
    public void successTest() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                .country("Österreich")
                .city("Wien")
                .street("Molkereistrasse")
                .postalCode("1020")
                .build());
        assertNotNull(geoCoordinate);
    }

    @Test
    public void successTestWithCorrectLatLon() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                .country("Österreich")
                .city("Wien")
                .street("Molkereistrasse")
                .postalCode("1020")
                .build());
        assertNotNull(geoCoordinate);
        assertEquals(new Double(48.2179768), geoCoordinate.getLat());
        assertEquals(new Double(16.4011212), geoCoordinate.getLon());
    }
}