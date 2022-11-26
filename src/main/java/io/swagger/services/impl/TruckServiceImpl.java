package io.swagger.services.impl;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.TruckEntity;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//TODO: hopentity durch richtige entities ersetzen (mit zusätlicher bedingung)
@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private HopRepository repository;

    @Override
    public void save(TruckEntity entity) {
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
