package at.fhtw3.swen3.services.mapper;

import at.fhtw3.swen3.persistence.entities.HopEntity;
import at.fhtw3.swen3.services.dto.GeoCoordinate;
import at.fhtw3.swen3.services.dto.Hop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HopMapperTest {

    Hop hop= new Hop().processingDelayMins(2).code("ABC1").hopType("test").description("ABC").locationName("ABC").locationCoordinates(new GeoCoordinate().lon(19.2).lat(91.2));

    @Test
    void fromDTO() {
        HopEntity entity= HopMapper.INSTANCE.fromDTO(hop);
        assertEquals(hop.getCode(), entity.getCode());
        assertEquals(hop.getDescription(), entity.getDescription());
        assertEquals(hop.getHopType(), entity.getHopType());
        assert(hop.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert(hop.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());
        assertEquals(hop.getLocationName(), entity.getLocationName());
        assertEquals(hop.getProcessingDelayMins(), entity.getProcessingDelayMins());
    }

    @Test
    void fromEntity() {
        HopEntity entity= HopMapper.INSTANCE.fromDTO(hop);
        Hop newHop= HopMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getCode(), newHop.getCode());
        assertEquals(entity.getDescription(), newHop.getDescription());
        assertEquals(entity.getHopType(), newHop.getHopType());
        assert(entity.getLocationCoordinates().getX() == newHop.getLocationCoordinates().getLon());
        assert(entity.getLocationCoordinates().getY() == newHop.getLocationCoordinates().getLat());
        assertEquals(entity.getLocationName(), newHop.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newHop.getProcessingDelayMins());
    }
}