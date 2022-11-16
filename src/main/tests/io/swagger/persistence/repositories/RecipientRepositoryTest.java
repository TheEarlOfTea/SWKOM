package io.swagger.persistence.repositories;

import io.swagger.services.dto.Recipient;
import io.swagger.services.mapper.RecipientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipientRepositoryTest {
    @Autowired
    RecipientRepository recipientRepository;
    @Autowired
    ParcelRepository parcelRepository;

    public Recipient dummyRecipient;

    @BeforeEach
    void init() {
        parcelRepository.deleteAll();
        recipientRepository.deleteAll();
        dummyRecipient= new Recipient();
        dummyRecipient.setDummyData();
    }

    @Test
    public void testSave() {


        recipientRepository.save(RecipientMapper.INSTANCE.fromDTO(dummyRecipient));

        assertEquals(1, recipientRepository.count());
    }
}