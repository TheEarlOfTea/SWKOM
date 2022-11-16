package io.swagger.services;


import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.Recipient;

import java.util.List;

public interface RecipientService {
    void save(RecipientEntity entity);
    List<RecipientEntity> findAll();
    void deleteById(long id);
    RecipientEntity getById(long id);
}
