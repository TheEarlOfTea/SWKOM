package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipientRepositoryTest {
    @Autowired
    RecipientRepository repository;

    public Recipient dummyRecipient;

    @BeforeEach
    void init() {
        dummyRecipient= new Recipient();
        dummyRecipient.setDummyData();
    }

    @Test
    public void testDB() {


        RecipientEntity recipientEntity= repository.save(RecipientMapper.INSTANCE.fromDTO(dummyRecipient));
        Optional<RecipientEntity> optionalRecipientEntity= repository.findById(recipientEntity.getId());

        assert(optionalRecipientEntity.isPresent());

        repository.delete(recipientEntity);
    }
}