package io.swagger.services;




import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.services.dto.Error;

import java.util.List;

public interface ErrorService {
    // Save operation
    ErrorEntity saveErrorEntity(Error error);

    // Read operation
    List<Error> fetchErrorEntityList();

    //getAll
    void getAllErrorEntity(Error error);

    //getAll
    void findErrorEntityByIdAll(Long errorId);

    // Delete operation
    void deleteErrorEntityById(Long errorId);
}
