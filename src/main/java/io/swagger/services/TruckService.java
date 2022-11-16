package io.swagger.services;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.TruckEntity;

import java.util.List;

public interface TruckService {
    void save(TruckEntity entity);
    List<HopEntity> findAll();
    void deleteById(long id);
    HopEntity getById(long id);
}
