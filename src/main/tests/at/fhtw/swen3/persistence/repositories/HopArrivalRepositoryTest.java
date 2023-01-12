package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.GeoCoordinateMapper;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.threeten.bp.OffsetDateTime;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopArrivalRepositoryTest {
    @Autowired
    HopArrivalRepository repository;

    public HopArrival hopArrival;

    @BeforeEach
    void init() {
        hopArrival = new HopArrival();
        hopArrival.setCode("ABCD123");
        hopArrival.setDateTime(OffsetDateTime.MAX);
        hopArrival.setDescription("ABSD");
    }

    @Test
    public void testDb() {

        HopArrivalEntity entity= repository.save(HopArrivalMapper.INSTANCE.fromDTO(hopArrival));

        Optional<HopArrivalEntity> optionalErrorEntity= repository.findById(entity.getId());

        assert(optionalErrorEntity.isPresent());

        repository.delete(entity);
    }
}