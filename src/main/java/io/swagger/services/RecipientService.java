package io.swagger.services;


import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.Recipient;

import java.util.List;

public interface RecipientService {
    // Save operation
    RecipientEntity saveRecipientEntity(Recipient recipient);

    // Read operation
    List<Recipient> fetchRecipientEntityList();

    //getAll
    void getAllRecipientEntity(Recipient recipient);

    //getAll
    void findRecipientEntityByIdAll(Long recipientId);

    // Delete operation
    void deleteRecipientEntityById(Long recipientId);
}
