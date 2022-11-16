package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.HopArrivalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.threeten.bp.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopArrivalRepositoryTest {
    @Autowired
    HopArrivalRepository hopArrivalRepository;

    public HopArrivalEntity entity;

    @BeforeEach
    void init() {
        hopArrivalRepository.deleteAll();
        entity = new HopArrivalEntity();
        entity.setCode("ABCD123");
        entity.setDateTime(OffsetDateTime.MAX);
        entity.setDescription("ABSD");
    }

    @Test
    public void testSave() {


        hopArrivalRepository.save(entity);

        assertEquals(1, hopArrivalRepository.count());
    }
}