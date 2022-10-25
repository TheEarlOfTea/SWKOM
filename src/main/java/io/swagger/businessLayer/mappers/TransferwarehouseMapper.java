package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.TransferwarehouseDataAccessEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    TransferwarehouseDataAccessEntity fromDTO(Transferwarehouse recipient);
    Transferwarehouse fromEntity(TransferwarehouseDataAccessEntity entity);
}
