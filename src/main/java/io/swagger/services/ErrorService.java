package io.swagger.services;




import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.services.dto.Error;

import java.util.List;

public interface ErrorService {

    void save(ErrorEntity error);
    List<ErrorEntity> findAll();
    void deleteById(long id);
    ErrorEntity getById(long id);



}
