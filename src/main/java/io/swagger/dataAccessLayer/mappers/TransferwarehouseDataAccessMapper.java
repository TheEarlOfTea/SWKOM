package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.TransferwarehouseBusinessEntity;
import io.swagger.dataAccessLayer.entities.TransferwarehouseDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseDataAccessMapper {
    TransferwarehouseDataAccessMapper INSTANCE= Mappers.getMapper(TransferwarehouseDataAccessMapper.class);
    TransferwarehouseDataAccessEntity fromBusinessEntity(TransferwarehouseBusinessEntity businessEntity);
    TransferwarehouseBusinessEntity fromDataAccessEntity(TransferwarehouseDataAccessEntity dataAccessEntity);
}
