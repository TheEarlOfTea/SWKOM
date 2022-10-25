package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.WarehouseDataAccessEntity;
import io.swagger.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    WarehouseDataAccessEntity fromDTO(Warehouse warehouse);
    Warehouse fromEntity(WarehouseDataAccessEntity entity);
}
