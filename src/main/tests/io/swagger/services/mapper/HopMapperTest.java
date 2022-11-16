package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.GeoCoordinate;
import io.swagger.services.dto.Hop;
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
        assertEquals(hop.getLocationCoordinates().getLon(), entity.getLocationCoordinates().getLon());
        assertEquals(hop.getLocationCoordinates().getLat(), entity.getLocationCoordinates().getLat());
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
        assertEquals(entity.getLocationCoordinates().getLon(), newHop.getLocationCoordinates().getLon());
        assertEquals(entity.getLocationCoordinates().getLat(), newHop.getLocationCoordinates().getLat());
        assertEquals(entity.getLocationName(), newHop.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newHop.getProcessingDelayMins());
    }
}