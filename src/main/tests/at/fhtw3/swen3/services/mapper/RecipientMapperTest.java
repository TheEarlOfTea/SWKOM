package at.fhtw3.swen3.services.mapper;

import at.fhtw3.swen3.persistence.entities.RecipientEntity;
import at.fhtw3.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipientMapperTest {

    Recipient recipient= new Recipient().city("City").name("Name").country("Country").postalCode("1234").street("abc");

    @Test
    void fromDTO() {
        RecipientEntity entity= RecipientMapper.INSTANCE.fromDTO(recipient);
        assertEquals(recipient.getCity(),entity.getCity());
        assertEquals(recipient.getName(),entity.getName());
        assertEquals(recipient.getCountry(),entity.getCountry());
        assertEquals(recipient.getPostalCode(),entity.getPostalCode());
        assertEquals(recipient.getStreet(),entity.getStreet());
    }

    @Test
    void fromEntity() {
        RecipientEntity entity= RecipientMapper.INSTANCE.fromDTO(recipient);
        Recipient newRecipient= RecipientMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getCity(), newRecipient.getCity());
        assertEquals(entity.getName(), newRecipient.getName());
        assertEquals(entity.getCountry(), newRecipient.getCountry());
        assertEquals(entity.getPostalCode(), newRecipient.getPostalCode());
        assertEquals(entity.getStreet(), newRecipient.getStreet());
    }
}