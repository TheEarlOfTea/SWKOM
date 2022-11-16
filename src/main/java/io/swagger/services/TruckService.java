package io.swagger.services;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Truck;

import java.util.List;

public interface TruckService {
    // Save operation
    TruckEntity saveTruckEntity(Truck truck);

    // Read operation
    List<Truck> fetchTruckEntityList();

    //getAll
    void getAllTruckEntity(Truck truck);

    //getAll
    void findTruckEntityByIdAll(Long truckId);

    // Delete operation
    void deleteTruckEntityById(Long truckId);
}
