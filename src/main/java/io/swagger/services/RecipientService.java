package io.swagger.services;


import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.Recipient;

import java.util.List;

public interface RecipientService {
    RecipientEntity saveRecipient(Recipient recipient);
    List<Recipient> findAllRecipients();
    void deleteRecipientById(long id);
    Recipient getRecipientById(long id);
    RecipientEntity findRecipient(Recipient recipient);
}
