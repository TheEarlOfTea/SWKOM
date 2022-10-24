package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.ErrorEntity;
import io.swagger.businessLayer.entities.GeoCoordinateEntity;
import io.swagger.services.dto.Error;
import io.swagger.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {

    GeoCoordinateMapper INSTANCE= Mappers.getMapper(GeoCoordinateMapper.class);

    GeoCoordinateEntity fromDTO(GeoCoordinate error);
    GeoCoordinate fromEntity(GeoCoordinateEntity entity);

}
