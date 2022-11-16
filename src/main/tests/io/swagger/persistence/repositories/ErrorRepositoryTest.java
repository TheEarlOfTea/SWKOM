package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorRepositoryTest {

    @Autowired
    ErrorRepository repository;

    public ErrorEntity entity;

    @BeforeEach
    void init() {
        repository.deleteAll();
        entity = new ErrorEntity();
        entity.setErrorMessage("test");
    }

    @Test
    public void testSaveNewRecipient() {


        repository.save(entity);

        assertEquals(1, repository.count());
    }
}