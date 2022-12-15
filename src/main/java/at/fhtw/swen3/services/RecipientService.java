package at.fhtw.swen3.services;


import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.persistence.entities.RecipientEntity;

import java.util.List;

public interface RecipientService {
    RecipientEntity saveRecipient(Recipient recipient);
    List<Recipient> findAllRecipients();
    void deleteRecipientById(long id);
    Recipient getRecipientById(long id);
    RecipientEntity findRecipient(Recipient recipient);
}
