package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.ErrorEntity;
import io.swagger.businessLayer.entities.HopArrivalEntity;
import io.swagger.services.dto.Error;
import io.swagger.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);

    HopArrivalEntity fromDTO(HopArrival error);
    HopArrival fromEntity(HopArrivalEntity entity);
}
