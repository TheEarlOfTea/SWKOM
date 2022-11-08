package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipientRepositoryTest {

    @Autowired
    RecipientRepository repository;

    public RecipientEntity entity;
    @BeforeEach
    void init(){
        entity= new RecipientEntity().builder().city("test").country("test").name("test").postalCode("test").street("test").build();
    }

    @Test
    public void testSaveEntity(){
        repository.deleteAll();
        repository.save(entity);
        assertEquals(1, repository.count());

    }
}