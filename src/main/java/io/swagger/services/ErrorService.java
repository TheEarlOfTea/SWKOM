package io.swagger.services;




import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.services.dto.Error;

import java.util.List;

public interface ErrorService {

    void save(Error error);
    List<Error> findAll();
    void deleteById(long id);
    Error getById(long id);



}
