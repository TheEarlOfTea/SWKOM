package io.swagger.services;


import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.WarehouseEntity;

import java.util.List;

public interface WarehouseService {
    void save(WarehouseEntity entity);
    List<HopEntity> findAll();
    void deleteById(long id);
    HopEntity getById(long id);
}
