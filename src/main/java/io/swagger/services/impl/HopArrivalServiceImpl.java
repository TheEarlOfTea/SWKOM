package io.swagger.services.impl;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.repositories.HopArrivalRepository;
import io.swagger.services.HopArrivalService;
import io.swagger.services.dto.HopArrival;
import io.swagger.services.mapper.HopArrivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class HopArrivalServiceImpl implements HopArrivalService {

    @Autowired
    private HopArrivalRepository hopArrivalRepository;
    @Autowired
    private HopArrivalMapper hopArrivalMapper;


    // Save operation
    @Override
    public HopArrivalEntity saveHopArrivalEntity(HopArrival hopArrival) {
        return hopArrivalRepository.save(hopArrivalMapper.fromDTO(hopArrival));
    }


    // Read operation
    @Override public List<HopArrival> fetchHopArrivalEntityList() {
        List<HopArrival> hopsArrival = new LinkedList<>();
        for (HopArrivalEntity hopArrivalEntity:hopArrivalRepository.findAll()) {
            hopsArrival.add(hopArrivalMapper.fromEntity(hopArrivalEntity));
        }
        return hopsArrival;
    }


    // Delete operation
    @Override
    public void deleteHopArrivalEntityById(Long Id) {
        hopArrivalRepository.deleteById(Id);
    }

    @Override
    public void getAllHopArrivalEntity(HopArrival hopArrival) {
    }

    @Override
    public void findHopArrivalEntityByIdAll(Long hopArrivalId) {
    }


}
