package io.swagger.services.mapper;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper extends CoordinateToPointMapper{
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    TransferwarehouseEntity fromDTO(Transferwarehouse transferwarehouse);
    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    Transferwarehouse fromEntity(TransferwarehouseEntity entity);
}
