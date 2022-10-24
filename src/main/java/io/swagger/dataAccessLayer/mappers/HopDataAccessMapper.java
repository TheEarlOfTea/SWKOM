package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.HopBusinessEntity;
import io.swagger.dataAccessLayer.entities.HopDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopDataAccessMapper {
    HopDataAccessMapper INSTANCE= Mappers.getMapper(HopDataAccessMapper.class);

    HopDataAccessEntity fromBusinessEntity(HopBusinessEntity businessEntity);
    HopBusinessEntity fromDataAccessEntity(HopDataAccessEntity dataAccessEntity);
}
