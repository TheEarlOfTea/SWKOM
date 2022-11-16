package io.swagger.services.mapper;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper extends CoordinateToPointMapper{

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    TruckEntity fromDTO(Truck hop);
    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    Truck fromEntity(TruckEntity entity);
}
