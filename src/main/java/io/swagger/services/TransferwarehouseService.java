package io.swagger.services;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.TransferwarehouseEntity;

import java.util.List;

public interface TransferwarehouseService {
    void save(TransferwarehouseEntity entity);
    List<HopEntity> findAll();
    void deleteById(long id);
    HopEntity getById(long id);
}
