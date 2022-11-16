package io.swagger.services.impl;


import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.persistence.repositories.WarenhouseRepository;
import io.swagger.services.WarehouseService;
import io.swagger.services.dto.Warehouse;
import io.swagger.services.mapper.WarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarenhouseRepository warenhouseRepository;
    @Autowired
    private WarehouseMapper warehouseMapper;

    // Save operation
    @Override
    public WarehouseEntity saveWarehouseEntity(Warehouse warehouse) {
        return warenhouseRepository.save(warehouseMapper.fromDTO(warehouse));
    }


    // Read operation
    @Override public List<Warehouse> fetchWarehouseEntityList() {
        List<Warehouse> warehouses = new LinkedList<>();
        for (WarehouseEntity warehouseEntity:warenhouseRepository.findAll()) {
            warehouses.add(warehouseMapper.fromEntity(warehouseEntity));
        }
        return warehouses;
    }

    @Override
    public void getAllWarehouseEntity(Warehouse warehouse) {

    }

    @Override
    public void findWarehouseEntityByIdAll(Long warenhouseId) {

    }


    // Delete operation
    @Override
    public void deleteWarehouseEntityById(Long Id){
        warenhouseRepository.deleteById(Id);
    }

}
