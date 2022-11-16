package io.swagger.services;
import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;

import java.util.List;

public interface HopService {

        // Save operation
        HopEntity saveHopEntity(Hop hop);

        // Read operation
        List<Hop> fetchHopEntityList();

        //getAll
        void getAllHopEntity(Hop hop);

        //getAll
        void findHopEntityByIdAll(Long hopId);

        // Delete operation
        void deleteHopEntityById(Long hopId);

//getAll(), findById, deleteById(), save()


}
