package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.WarehouseNextHopsBusinessEntity;
import io.swagger.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    WarehouseNextHopsBusinessEntity fromDTO(WarehouseNextHops warehouseNextHops);
    WarehouseNextHops fromEntity(WarehouseNextHopsBusinessEntity entity);
}
