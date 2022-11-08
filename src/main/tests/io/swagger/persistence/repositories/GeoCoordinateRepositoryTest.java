package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.entities.GeoCoordinateEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoCoordinateRepositoryTest {

    @Autowired
    GeoCoordinateRepository repository;

    public GeoCoordinateEntity entity;
    @BeforeEach
    void init(){
        entity= new GeoCoordinateEntity().builder().lat(119.19).lon(160.34).build();
    }

    @Test
    public void testSaveEntity(){
        repository.deleteAll();
        repository.save(entity);
        assertEquals(1, repository.count());

    }
}