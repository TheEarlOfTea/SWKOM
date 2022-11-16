package io.swagger.services.impl;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.persistence.repositories.ParcelRepository;
import io.swagger.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository repository;

    @Override
    public void save(ParcelEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<ParcelEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public ParcelEntity getById(long id) {
        Optional<ParcelEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
