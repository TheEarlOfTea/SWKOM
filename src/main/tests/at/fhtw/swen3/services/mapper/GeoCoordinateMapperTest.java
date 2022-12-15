package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoCoordinateMapperTest {

    GeoCoordinate coordinate= new GeoCoordinate().lat(19.1).lon(19.2);

    @Test
    void fromDTO() {
        GeoCoordinateEntity entity= GeoCoordinateMapper.INSTANCE.fromDTO(coordinate);
        assertEquals(coordinate.getLat(), entity.getLat());
        assertEquals(coordinate.getLon(), entity.getLon());

    }

    @Test
    void fromEntity() {
        GeoCoordinateEntity entity= GeoCoordinateMapper.INSTANCE.fromDTO(coordinate);
        GeoCoordinate newCoordinate= GeoCoordinateMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getLat(), newCoordinate.getLat());
        assertEquals(entity.getLon(), newCoordinate.getLon());
    }
}