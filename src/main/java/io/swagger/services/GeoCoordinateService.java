package io.swagger.services;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.services.dto.GeoCoordinate;

import java.util.List;

public interface GeoCoordinateService {
    // Save operation
    GeoCoordinateEntity saveGeoCoordinateEntity(GeoCoordinate geoCoordinate);

    // Read operation
    List<GeoCoordinate> fetchGeoCoordinateEntityList();

    //getAll
    void getAllGeoCoordinateEntity(GeoCoordinate geoCoordinate);

    //getAll
    void findGeoCoordinateEntityByIdAll(Long geoCoordinateId);

    // Delete operation
    void deleteGeoCoordinateEntityById(Long geoCoordinateId);
}
