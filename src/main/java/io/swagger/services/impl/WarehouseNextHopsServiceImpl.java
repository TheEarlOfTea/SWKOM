package io.swagger.services.impl;


import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.persistence.repositories.WarenhouseNextHopsRepository;
import io.swagger.services.WarehouseNextHopsService;
import io.swagger.services.dto.WarehouseNextHops;
import io.swagger.services.mapper.WarehouseNextHopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WarehouseNextHopsServiceImpl implements WarehouseNextHopsService {
    @Autowired
    private WarenhouseNextHopsRepository warenhouseNextHopsRepository;
    @Autowired
    private WarehouseNextHopMapper warehouseNextHopMapper;

    // Save operation
    @Override
    public WarehouseNextHopsEntity saveWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops) {
        return warenhouseNextHopsRepository.save(warehouseNextHopMapper.fromDTO(warehouseNextHops));
    }


    // Read operation
    @Override public List<WarehouseNextHops> fetchWarehouseNextHopsEntityList() {
        List<WarehouseNextHops> warehouseNextHops = new LinkedList<>();
        for (WarehouseNextHopsEntity warehouseNextHopsEntity:warenhouseNextHopsRepository.findAll()) {
            warehouseNextHops.add(warehouseNextHopMapper.fromEntity(warehouseNextHopsEntity));
        }
        return warehouseNextHops;
    }

    @Override
    public void getAllWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHops) {

    }

    @Override
    public void findWarehouseNextHopsEntityByIdAll(Long warenhouseNextHopsId) {

    }

    // Delete operation
    @Override
    public void deleteWarehouseNextHopsEntityById(Long Id){
        warenhouseNextHopsRepository.deleteById(Id);
    }
}
