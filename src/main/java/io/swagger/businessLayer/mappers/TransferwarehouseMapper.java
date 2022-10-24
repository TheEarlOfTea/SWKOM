package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.TransferwarehouseBusinessEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    TransferwarehouseBusinessEntity fromDTO(Transferwarehouse recipient);
    Transferwarehouse fromEntity(TransferwarehouseBusinessEntity entity);
}
