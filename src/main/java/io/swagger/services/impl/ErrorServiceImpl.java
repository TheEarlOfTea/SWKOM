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

@Service
public class ErrorServiceImpl implements ErrorService {
    @Autowired
    private ErrorRepository errorRepository;
    @Autowired
    private ErrorMapper errorMapper;

    // Save operation
    @Override
    public ErrorEntity saveErrorEntity(Error error) {
        return errorRepository.save(errorMapper.fromDTO(error));
    }


    // Read operation
    @Override public List<Error> fetchErrorEntityList() {
        List<Error> errors = new LinkedList<>();
        for (ErrorEntity errorEntity:errorRepository.findAll()) {
            errors.add(errorMapper.fromEntity(errorEntity));
        }
        return errors;
    }

    @Override
    public void getAllErrorEntity(Error error) {

    }

    @Override
    public void findErrorEntityByIdAll(Long errorId) {

    }


    // Delete operation
    @Override
    public void deleteErrorEntityById(Long Id){
        errorRepository.deleteById(Id);
    }
}
