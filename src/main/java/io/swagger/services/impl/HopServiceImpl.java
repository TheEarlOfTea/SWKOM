package io.swagger.services.impl;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.repositories.HopArrivalRepository;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.services.HopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HopServiceImpl implements HopService {

    @Autowired
    private HopRepository repository;

    @Override
    public void save(HopEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<HopEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public HopEntity getById(long id) {
        Optional<HopEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
