package io.swagger.services;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.services.dto.HopArrival;
import java.util.List;

public interface HopArrivalService {

    // Save operation
    HopArrivalEntity saveHopArrivalEntity(HopArrival hopArrival);

    // Read operation
    List<HopArrival> fetchHopArrivalEntityList();

    //getAll
    void getAllHopArrivalEntity(HopArrival hopArrival);

    //getAll
    void findHopArrivalEntityByIdAll(Long hopArrivalId);

    // Delete operation
    void deleteHopArrivalEntityById(Long hopArrivalId);


}
