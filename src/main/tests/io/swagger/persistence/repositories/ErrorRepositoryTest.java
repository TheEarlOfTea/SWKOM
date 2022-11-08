package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ErrorRepositoryTest {

    @Autowired
    ErrorRepository errorRepository;

    public ErrorEntity entity;
    @BeforeEach
    void init(){
        entity= new ErrorEntity().builder().errorMessage("test").build();
    }

    @Test
    public void testSaveEntity(){
        errorRepository.deleteAll();
        errorRepository.save(entity);
        assertEquals(1, errorRepository.count());

    }
}