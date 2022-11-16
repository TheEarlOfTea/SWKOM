package io.swagger.services;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.services.dto.HopArrival;
import java.util.List;

public interface HopArrivalService {

    void save(HopArrival hopArrival);
    List<HopArrival> findAll();
    void deleteById(long id);
    HopArrival getById(long id);


}
