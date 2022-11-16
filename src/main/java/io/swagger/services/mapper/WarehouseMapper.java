package io.swagger.services.mapper;

import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "level", target = "level")
    @Mapping(source = "nextHops", target = "nextHops")
    WarehouseEntity fromDTO(Warehouse warehouse);

    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "level", target = "level")
    @Mapping(source = "nextHops", target = "nextHops")
    Warehouse fromEntity(WarehouseEntity entity);
}
