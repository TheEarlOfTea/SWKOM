package io.swagger.services.mapper;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckMapperTest {

    Truck truck= new Truck().numberPlate("ABCD").regionGeoJson("abcd");

    @Test
    void fromDTO() {
        truck.setDummyData();
        TruckEntity entity= TruckMapper.INSTANCE.fromDTO(truck);

        assertEquals(truck.getCode(), entity.getCode());
        assertEquals(truck.getDescription(), entity.getDescription());
        assertEquals(truck.getHopType(), entity.getHopType());
        assert(truck.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert(truck.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());
        assertEquals(truck.getLocationName(), entity.getLocationName());
        assertEquals(truck.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(truck.getRegionGeoJson(), entity.getRegionGeoJson());
        assertEquals(truck.getNumberPlate(), entity.getNumberPlate());
    }

    @Test
    void fromEntity() {

        truck.setDummyData();
        TruckEntity entity= TruckMapper.INSTANCE.fromDTO(truck);
        Truck newTruck= TruckMapper.INSTANCE.fromEntity(entity);

        assertEquals(entity.getCode(), newTruck.getCode());
        assertEquals(entity.getDescription(), newTruck.getDescription());
        assertEquals(entity.getHopType(), newTruck.getHopType());
        assert(entity.getLocationCoordinates().getX() == newTruck.getLocationCoordinates().getLon());
        assert(entity.getLocationCoordinates().getY() == newTruck.getLocationCoordinates().getLat());
        assertEquals(entity.getLocationName(), newTruck.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newTruck.getProcessingDelayMins());
        assertEquals(entity.getRegionGeoJson(), newTruck.getRegionGeoJson());
        assertEquals(entity.getNumberPlate(), newTruck.getNumberPlate());
    }
}