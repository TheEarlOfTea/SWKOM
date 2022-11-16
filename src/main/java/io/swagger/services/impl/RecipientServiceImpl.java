package io.swagger.services.impl;

import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.persistence.repositories.ParcelRepository;
import io.swagger.persistence.repositories.RecipientRepository;
import io.swagger.services.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private RecipientRepository repository;

    @Override
    public void save(RecipientEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<RecipientEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public RecipientEntity getById(long id) {
        Optional<RecipientEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
