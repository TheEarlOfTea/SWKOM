package io.swagger.services;


import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import io.swagger.services.dto.WarehouseNextHops;

import java.util.List;

public interface WarehouseService {
    void save(Warehouse warehouse);
    List<Warehouse> findAll();
    void deleteById(long id);
    Warehouse getById(long id);
}
