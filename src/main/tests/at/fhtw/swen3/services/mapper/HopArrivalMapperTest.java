package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import org.junit.jupiter.api.Test;
import org.threeten.bp.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HopArrivalMapperTest {

    HopArrival arrival= new HopArrival().code("ABC1").description("ABC").dateTime(OffsetDateTime.MAX);

    @Test
    void fromDTO() {
        HopArrivalEntity entity= HopArrivalMapper.INSTANCE.fromDTO(arrival);
        assertEquals(arrival.getCode(), entity.getCode());
        assertEquals(arrival.getDateTime(), entity.getDateTime());
        assertEquals(arrival.getDescription(), entity.getDescription());
    }

    @Test
    void fromEntity() {
        HopArrivalEntity entity= HopArrivalMapper.INSTANCE.fromDTO(arrival);
        HopArrival newArrival= HopArrivalMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getCode(), newArrival.getCode());
        assertEquals(entity.getDateTime(), newArrival.getDateTime());
        assertEquals(entity.getDescription(), newArrival.getDescription());
    }
}