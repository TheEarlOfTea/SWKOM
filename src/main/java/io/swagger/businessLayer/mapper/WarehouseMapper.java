package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    WarehouseEntity fromDTO(Warehouse warehouse);
    Warehouse fromEntity(WarehouseEntity entity);
}
