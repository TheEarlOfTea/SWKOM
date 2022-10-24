package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.GeoCoordinateBusinessEntity;
import io.swagger.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {

    GeoCoordinateMapper INSTANCE= Mappers.getMapper(GeoCoordinateMapper.class);

    GeoCoordinateBusinessEntity fromDTO(GeoCoordinate error);
    GeoCoordinate fromEntity(GeoCoordinateBusinessEntity entity);

}
