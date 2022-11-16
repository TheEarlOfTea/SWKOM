package io.swagger.services;

import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.services.dto.WarehouseNextHops;

import java.util.List;

public interface WarehouseNextHopsService {
    // Save operation
    WarehouseNextHopsEntity saveWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops);

    // Read operation
    List<WarehouseNextHops> fetchWarehouseNextHopsEntityList();

    //getAll
    void getAllWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops);

    //getAll
    void findWarehouseNextHopsEntityByIdAll(Long warenhouseNextHopsId);

    // Delete operation
    void deleteWarehouseNextHopsEntityById(Long warenhouseNextHopsId);
}
