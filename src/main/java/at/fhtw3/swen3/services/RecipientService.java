package at.fhtw3.swen3.services;


import at.fhtw3.swen3.persistence.entities.RecipientEntity;
import at.fhtw3.swen3.services.dto.Recipient;

import java.util.List;

public interface RecipientService {
    RecipientEntity saveRecipient(Recipient recipient);
    List<Recipient> findAllRecipients();
    void deleteRecipientById(long id);
    Recipient getRecipientById(long id);
    RecipientEntity findRecipient(Recipient recipient);
}
