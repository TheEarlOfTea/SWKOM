package io.swagger.gps;


import io.swagger.services.dto.GeoCoordinate;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface GeoEncodingService {

        GeoCoordinate encodeAddress(GeoCoordinate address)throws IOException, InterruptedException;

}
