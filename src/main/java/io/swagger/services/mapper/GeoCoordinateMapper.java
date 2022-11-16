package io.swagger.services.mapper;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {

    GeoCoordinateMapper INSTANCE= Mappers.getMapper(GeoCoordinateMapper.class);

    @Mapping(source = "lat", target = "lat")
    @Mapping(source = "lon", target = "lon")
    GeoCoordinateEntity fromDTO(GeoCoordinate error);
    @Mapping(source = "lat", target = "lat")
    @Mapping(source = "lon", target = "lon")
    GeoCoordinate fromEntity(GeoCoordinateEntity entity);

}
