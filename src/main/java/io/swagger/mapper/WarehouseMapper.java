package io.swagger.mapper;

import io.swagger.persistence.entity.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    WarehouseEntity from(Warehouse warehouse);


}
