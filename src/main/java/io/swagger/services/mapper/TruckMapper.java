package io.swagger.services.mapper;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson")
    @Mapping(source = "numberPlate", target = "numberPlate")
    TruckEntity fromDTO(Truck hop);
    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson")
    @Mapping(source = "numberPlate", target = "numberPlate")
    Truck fromEntity(TruckEntity entity);
}
