package at.fhtw3.swen3.persistence.repositories;

import at.fhtw3.swen3.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void testSave() {


        repository.save(entity);

        assertEquals(1, repository.count());
    }
}