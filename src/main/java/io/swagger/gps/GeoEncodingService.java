package io.swagger.gps;

import at.fhtw3.swen3.services.dto.GeoCoordinate;
import io.swagger.gps.service.Address;

import java.io.IOException;

public interface GeoEncodingService {

        GeoCoordinate encodeAddress(Address address)throws IOException, InterruptedException;

}
