package at.fhtw3.swen3.services;

import at.fhtw3.swen3.services.dto.GeoCoordinate;

import java.util.List;

public interface GeoCoordinateService {
    void saveGeoCoordinate(GeoCoordinate geoCoordinate);
    List<GeoCoordinate> findAllGeoCoordinates();
    void deleteGeoCoordinateById(long id);
    GeoCoordinate getGeoCoordinateById(long id);
}
