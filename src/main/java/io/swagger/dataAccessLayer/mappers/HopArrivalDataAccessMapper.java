package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.HopArrivalBusinessEntity;
import io.swagger.dataAccessLayer.entities.HopArrivalDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopArrivalDataAccessMapper {
    HopArrivalDataAccessMapper INSTANCE= Mappers.getMapper(HopArrivalDataAccessMapper.class);

    HopArrivalDataAccessEntity fromBusinessEntity(HopArrivalBusinessEntity entity);
    HopArrivalBusinessEntity fromAccessLayerEntity(HopArrivalDataAccessEntity model);
}
