package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.RecipientEntity;
import io.swagger.businessLayer.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Recipient;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    TransferwarehouseEntity fromDTO(Transferwarehouse recipient);
    Transferwarehouse fromEntity(TransferwarehouseEntity entity);
}
