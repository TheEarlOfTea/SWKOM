package at.fhtw3.swen3.persistence.repositories;

import at.fhtw3.swen3.services.dto.Recipient;
import at.fhtw3.swen3.services.mapper.RecipientMapper;
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