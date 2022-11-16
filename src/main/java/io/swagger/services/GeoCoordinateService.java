package io.swagger.services;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.services.dto.GeoCoordinate;

import java.util.List;

public interface GeoCoordinateService {
    void save(GeoCoordinateEntity entity);
    List<GeoCoordinateEntity> findAll();
    void deleteById(long id);
    GeoCoordinateEntity getById(long id);
}
