package io.swagger.businessLayer.mappers;

import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    WarehouseNextHopsEntity fromDTO(WarehouseNextHops warehouseNextHops);
    WarehouseNextHops fromEntity(WarehouseNextHopsEntity entity);
}
