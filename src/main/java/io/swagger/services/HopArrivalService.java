package io.swagger.services;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.Recipient;

import java.util.List;

public interface HopArrivalService {

    HopArrivalEntity saveHopArrival(HopArrival hopArrival);
    List<HopArrivalEntity> saveMultipleHopArrivals(List<HopArrival> list);
    List<HopArrival> findAllHopArrivals();
    void deleteHopArrivalById(long id);
    HopArrival getHopArrivalById(long id);
    HopArrivalEntity findHopArrival(HopArrival hopArrival);


}
