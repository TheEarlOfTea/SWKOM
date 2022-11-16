package io.swagger.services.impl;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.repositories.ErrorRepository;
import io.swagger.services.ErrorService;
import io.swagger.services.dto.Error;
import io.swagger.services.mapper.ErrorMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorRepository repository;

    @Override
    public void save(Error error) {
        repository.save(ErrorMapper.INSTANCE.fromDTO(error));

    }

    @Override
    public List<Error> findAll() {
        LinkedList<Error> list= new LinkedList<Error>();
        for(ErrorEntity e : repository.findAll()){
            list.add(ErrorMapper.INSTANCE.fromEntity(e));
        }
        return list;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Error getById(long id) {
        Optional<ErrorEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return ErrorMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }
}
