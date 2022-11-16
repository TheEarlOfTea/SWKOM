package io.swagger.services;

import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.services.dto.Truck;
import io.swagger.services.dto.WarehouseNextHops;

import java.util.List;

public interface WarehouseNextHopsService {
    void save(WarehouseNextHops warehouseNextHops);
    List<WarehouseNextHops> findAll();
    void deleteById(long id);
    WarehouseNextHops getById(long id);
}
