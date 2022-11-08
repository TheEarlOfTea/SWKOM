package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);

    HopArrivalEntity fromDTO(HopArrival hopArrival);
    HopArrival fromEntity(HopArrivalEntity entity);
}
