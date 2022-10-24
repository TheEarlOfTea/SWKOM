package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.WarehouseBusinessEntity;
import io.swagger.dataAccessLayer.entities.WarehouseDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseDataAccessMapper {
    WarehouseDataAccessMapper INSTANCE= Mappers.getMapper(WarehouseDataAccessMapper.class);

    WarehouseDataAccessEntity fromBusinessEntity(WarehouseBusinessEntity businessEntity);
    WarehouseBusinessEntity fromDataAccessEntity(WarehouseDataAccessEntity dataAccessEntity);

}
