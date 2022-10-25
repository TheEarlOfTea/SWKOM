package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.HopArrivalDataAccessEntity;
import io.swagger.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);

    /*HopArrivalDataAccessEntity fromDTO(HopArrival error);
    HopArrival fromEntity(HopArrivalDataAccessEntity entity);*/
}
