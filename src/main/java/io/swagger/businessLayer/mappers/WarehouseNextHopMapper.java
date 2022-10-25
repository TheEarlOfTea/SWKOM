package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.WarehouseNextHopsDataAccessEntity;
import io.swagger.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    WarehouseNextHopsDataAccessEntity fromDTO(WarehouseNextHops warehouseNextHops);
    WarehouseNextHops fromEntity(WarehouseNextHopsDataAccessEntity entity);
}
