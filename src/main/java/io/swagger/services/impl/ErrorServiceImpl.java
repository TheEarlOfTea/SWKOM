package io.swagger.services.impl;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.repositories.ErrorRepository;
import io.swagger.services.ErrorService;
import io.swagger.services.dto.Error;
import io.swagger.services.mapper.ErrorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorRepository repository;

    @Override
    public void save(ErrorEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<ErrorEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public ErrorEntity getById(long id) {
        Optional<ErrorEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
