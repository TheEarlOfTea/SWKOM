package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import at.fhtw.swen3.services.mapper.GeoCoordinateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoCoordinateRepositoryTest {

    @Autowired
    GeoCoordinateRepository repository;

    @Test
    public void testDb() {

        GeoCoordinateEntity entity= repository.save(GeoCoordinateMapper.INSTANCE.fromDTO(new GeoCoordinate().lat(2.2).lon(2.2)));

        Optional<GeoCoordinateEntity> optionalErrorEntity= repository.findById(entity.getId());

        assert(optionalErrorEntity.isPresent());

        repository.delete(entity);
    }
}