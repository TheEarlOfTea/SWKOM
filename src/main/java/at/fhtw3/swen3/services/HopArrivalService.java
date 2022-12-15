package at.fhtw3.swen3.services;

import at.fhtw3.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw3.swen3.services.dto.HopArrival;

import java.util.List;

public interface HopArrivalService {

    HopArrivalEntity saveHopArrival(HopArrival hopArrival);
    List<HopArrivalEntity> saveMultipleHopArrivals(List<HopArrival> list);
    List<HopArrival> findAllHopArrivals();
    void deleteHopArrivalById(long id);
    HopArrival getHopArrivalById(long id);
    HopArrivalEntity findHopArrival(HopArrival hopArrival);


}
