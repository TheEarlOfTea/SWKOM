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
    public void saveError(Error error) {
        repository.save(ErrorMapper.INSTANCE.fromDTO(error));

    }

    @Override
    public List<Error> findAllErrors() {
        List<ErrorEntity> list=repository.findAll();
        LinkedList<Error> returnList= new LinkedList<Error>();
        for(ErrorEntity e: list){
            returnList.add(ErrorMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteErrorById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Error getErrorById(long id) {
        Optional<ErrorEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return ErrorMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }
}
