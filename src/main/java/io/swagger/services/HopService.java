package io.swagger.services;
import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.HopArrival;

import java.util.List;

public interface HopService {

        void save(HopEntity entity);
        List<HopEntity> findAll();
        void deleteById(long id);
        HopEntity getById(long id);


}
