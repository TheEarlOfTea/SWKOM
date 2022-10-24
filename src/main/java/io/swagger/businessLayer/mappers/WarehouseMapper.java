package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.WarehouseBusinessEntity;
import io.swagger.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    WarehouseBusinessEntity fromDTO(Warehouse warehouse);
    Warehouse fromEntity(WarehouseBusinessEntity entity);
}
