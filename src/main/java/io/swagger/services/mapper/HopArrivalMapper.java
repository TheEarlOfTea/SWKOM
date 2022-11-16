package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);

    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "dateTime", target = "dateTime")
    HopArrivalEntity fromDTO(HopArrival hopArrival);
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "dateTime", target = "dateTime")
    HopArrival fromEntity(HopArrivalEntity entity);
}
