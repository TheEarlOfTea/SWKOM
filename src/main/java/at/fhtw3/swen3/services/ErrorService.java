package at.fhtw3.swen3.services;


import at.fhtw3.swen3.services.dto.Error;

import java.util.List;

public interface ErrorService {

    void saveError(Error error);
    List<Error> findAllErrors();
    void deleteErrorById(long id);
    Error getErrorById(long id);



}
