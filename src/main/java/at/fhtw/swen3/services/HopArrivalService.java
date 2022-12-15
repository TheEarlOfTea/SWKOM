package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;

import java.util.List;

public interface HopArrivalService {

    HopArrivalEntity saveHopArrival(HopArrival hopArrival);
    List<HopArrivalEntity> saveMultipleHopArrivals(List<HopArrival> list);
    List<HopArrival> findAllHopArrivals();
    void deleteHopArrivalById(long id);
    HopArrival getHopArrivalById(long id);
    HopArrivalEntity findHopArrival(HopArrival hopArrival);


}
