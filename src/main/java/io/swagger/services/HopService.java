package io.swagger.services;
import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.HopArrival;

import java.util.List;

public interface HopService {

        void save(Hop hop);
        List<Hop> findAll();
        void deleteById(long id);
        Hop getById(long id);


}
