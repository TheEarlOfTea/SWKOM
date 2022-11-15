package io.swagger.services;


import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import java.util.List;

public interface WarehouseService {
    // Save operation
    WarehouseEntity saveWarehouseEntity(Warehouse warehouse);

    // Read operation
    List<Warehouse> fetchWarehouseEntityList();

    //getAll
    void getAllWarehouseEntity(Warehouse warehouse);

    //getAll
    void findWarehouseEntityByIdAll(Long warenhouseId);

    // Delete operation
    void deleteWarehouseEntityById(Long warenhouseId);
}
