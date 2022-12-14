package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper extends CoordinateToPointMapper{
    HopMapper INSTANCE= Mappers.getMapper(HopMapper.class);


    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    HopEntity fromDTO(Hop hop);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    Hop fromEntity(HopEntity entity);
}
