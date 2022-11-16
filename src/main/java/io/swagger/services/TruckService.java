package io.swagger.services;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Transferwarehouse;
import io.swagger.services.dto.Truck;

import java.util.List;

public interface TruckService {
    void save(Truck truck);
    List<Truck> findAll();
    void deleteById(long id);
    Truck getById(long id);
}
