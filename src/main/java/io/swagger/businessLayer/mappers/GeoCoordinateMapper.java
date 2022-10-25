package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.GeoCoordinateDataAccessEntity;
import io.swagger.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {

    GeoCoordinateMapper INSTANCE= Mappers.getMapper(GeoCoordinateMapper.class);

    GeoCoordinateDataAccessEntity fromDTO(GeoCoordinate error);
    GeoCoordinate fromEntity(GeoCoordinateDataAccessEntity entity);

}
