package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.GeoCoordinateBusinessEntity;
import io.swagger.dataAccessLayer.entities.GeoCoordinateDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateDataAccessMapper {
    GeoCoordinateDataAccessMapper INSTANCE= Mappers.getMapper(GeoCoordinateDataAccessMapper.class);

    GeoCoordinateDataAccessEntity fromBusinessEntity(GeoCoordinateBusinessEntity entity);
    GeoCoordinateBusinessEntity fromAccessLayerEntity(GeoCoordinateDataAccessEntity model);
}
