package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.WarehouseNextHopsBusinessEntity;
import io.swagger.dataAccessLayer.entities.WarehouseNextHopsDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopsDataAccessMapper {
    WarehouseNextHopsDataAccessMapper INSTANCE= Mappers.getMapper(WarehouseNextHopsDataAccessMapper.class);

    WarehouseNextHopsDataAccessEntity fromBusinessEntity(WarehouseNextHopsBusinessEntity businessEntity);
    WarehouseNextHopsBusinessEntity fromDataAccessEntity(WarehouseNextHopsDataAccessEntity dataAccessEntity);
}
