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
    void init() {
        repository.deleteAll();
        entity = new GeoCoordinateEntity();
        entity.setLat(12.2);
        entity.setLon(13.2);
    }

    @Test
    public void testSave() {


        repository.save(entity);

        assertEquals(1, repository.count());
    }
}