package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.HopArrivalBusinessEntity;
import io.swagger.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);

    HopArrivalBusinessEntity fromDTO(HopArrival error);
    HopArrival fromEntity(HopArrivalBusinessEntity entity);
}
