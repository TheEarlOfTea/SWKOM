package io.swagger.services;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.services.dto.GeoCoordinate;

import java.util.List;

public interface GeoCoordinateService {
    void save(GeoCoordinate geoCoordinate);
    List<GeoCoordinate> findAll();
    void deleteById(long id);
    GeoCoordinate getById(long id);
}
