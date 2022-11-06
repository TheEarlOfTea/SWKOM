package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.GeoCoordinateEntity;
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
    HopArrivalRepository repository;

    public HopArrivalEntity entity;
    @BeforeEach
    void init(){
        entity= new HopArrivalEntity().builder().code("test").description("test").dateTime(OffsetDateTime.MIN).build();
    }

    @Test
    public void testSaveEntity(){
        repository.deleteAll();
        repository.save(entity);
        assertEquals(1, repository.count());

    }
}