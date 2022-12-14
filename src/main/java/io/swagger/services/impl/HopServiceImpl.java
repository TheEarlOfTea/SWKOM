package io.swagger.services.impl;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.services.HopService;
import io.swagger.services.dto.Hop;
import io.swagger.services.mapper.HopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class HopServiceImpl implements HopService {

    @Autowired
    private HopRepository repository;

    @Override
    public void saveHop(Hop hop) {
        repository.save(HopMapper.INSTANCE.fromDTO(hop));

    }

    @Override
    public List<Hop> findAllHops() {
        List<HopEntity> list=repository.findAll();
        LinkedList<Hop> returnList= new LinkedList<Hop>();
        for(HopEntity e: list){
            returnList.add(HopMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteHopById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Hop getHopById(long id) {
        Optional<HopEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return HopMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }
}
