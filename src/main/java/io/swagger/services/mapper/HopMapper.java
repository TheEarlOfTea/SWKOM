package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE= Mappers.getMapper(HopMapper.class);

    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    HopEntity fromDTO(Hop hop);
    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    Hop fromEntity(HopEntity entity);
}
