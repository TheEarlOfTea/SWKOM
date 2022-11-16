package io.swagger.services.impl;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.repositories.ErrorRepository;
import io.swagger.persistence.repositories.HopArrivalRepository;
import io.swagger.services.HopArrivalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HopArrivalServiceImpl implements HopArrivalService {
    @Autowired
    private HopArrivalRepository repository;

    @Override
    public void save(HopArrivalEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<HopArrivalEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public HopArrivalEntity getById(long id) {
        Optional<HopArrivalEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }

}
