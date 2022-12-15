package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.services.HopArrivalService;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class HopArrivalServiceImpl implements HopArrivalService {
    @Autowired
    private HopArrivalRepository repository;


    @Override
    public HopArrivalEntity saveHopArrival(HopArrival hopArrival) {
        HopArrivalEntity oldEntity= findHopArrival(hopArrival);
        if(oldEntity!=null){
            System.out.println("hopArrival exists");
            return oldEntity;
        }
        return repository.save(HopArrivalMapper.INSTANCE.fromDTO(hopArrival));
    }

    @Override
    public List<HopArrivalEntity> saveMultipleHopArrivals(List<HopArrival> list){
        List<HopArrivalEntity> entityList= new LinkedList<HopArrivalEntity>();
        for (HopArrival h : list){
            entityList.add(saveHopArrival(h));
        }
        return entityList;
    }

    @Override
    public List<HopArrival> findAllHopArrivals() {
        List<HopArrivalEntity> list=repository.findAll();
        LinkedList<HopArrival> returnList= new LinkedList<HopArrival>();
        for(HopArrivalEntity e: list){
            returnList.add(HopArrivalMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteHopArrivalById(long id) {
        repository.deleteById(id);
    }

    @Override
    public HopArrival getHopArrivalById(long id) {
        Optional<HopArrivalEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return HopArrivalMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }

    @Override
    public HopArrivalEntity findHopArrival(HopArrival hopArrival) {
        ExampleMatcher matcher= ExampleMatcher.matching().withIgnorePaths("id");
        Optional<HopArrivalEntity> entity=repository.findOne(Example.of(HopArrivalMapper.INSTANCE.fromDTO(hopArrival), matcher));
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
