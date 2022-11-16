package io.swagger.services;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.services.dto.HopArrival;
import java.util.List;

public interface HopArrivalService {

    void save(HopArrivalEntity entity);
    List<HopArrivalEntity> findAll();
    void deleteById(long id);
    HopArrivalEntity getById(long id);


}
