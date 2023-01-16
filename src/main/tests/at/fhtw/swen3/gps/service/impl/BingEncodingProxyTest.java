package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.dto.GeoCoordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class BingEncodingProxyTest {
    @Test
    public void successTest() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = null;
        try {
            geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                    .country("Österreich")
                    .city("Wien")
                    .street("Molkereistrasse")
                    .postalCode("1020")
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(geoCoordinate);
    }

    @Test
    public void successTestWithCorrectLatLon() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = null;
        try {
            geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                    .country("Österreich")
                    .city("Wien")
                    .street("Molkereistrasse")
                    .postalCode("1020")
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(geoCoordinate);
        assert(48.2179768==geoCoordinate.getLat());
        assert(16.4011212==geoCoordinate.getLon());
    }
}