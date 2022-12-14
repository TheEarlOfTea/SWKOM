package io.swagger.services;


import io.swagger.services.dto.Error;

import java.util.List;

public interface ErrorService {

    void saveError(Error error);
    List<Error> findAllErrors();
    void deleteErrorById(long id);
    Error getErrorById(long id);



}
