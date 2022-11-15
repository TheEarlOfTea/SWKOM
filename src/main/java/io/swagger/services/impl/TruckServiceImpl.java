package io.swagger.services.impl;


import io.swagger.persistence.entities.TruckEntity;
import io.swagger.persistence.repositories.TruckRepository;
import io.swagger.services.TruckService;
import io.swagger.services.dto.Truck;
import io.swagger.services.mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service

public class TruckServiceImpl implements TruckService {
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private TruckMapper truckMapper;

    // Save operation
    @Override
    public TruckEntity saveTruckEntity(Truck truck) {
        return truckRepository.save(truckMapper.fromDTO(truck));
    }


    // Read operation
    @Override public List<Truck> fetchTruckEntityList() {
        List<Truck> trucks = new LinkedList<>();
        for (TruckEntity truckEntity:truckRepository.findAll()) {
            trucks.add(truckMapper.fromEntity(truckEntity));
        }
        return trucks;
    }

    // Delete operation
    @Override
    public void deleteTruckEntityById(Long Id){
        truckRepository.deleteById(Id);
    }


    @Override
    public void getAllTruckEntity(Truck truck) {

    }

    @Override
    public void findTruckEntityByIdAll(Long truckId) {

    }


}
