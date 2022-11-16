package io.swagger.services.mapper;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);


    TransferwarehouseEntity fromDTO(Transferwarehouse transferwarehouse);

    Transferwarehouse fromEntity(TransferwarehouseEntity entity);
}
