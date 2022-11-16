package io.swagger.services.mapper;

import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    @Mapping(source = "travelTimeMins", target = "travelTimeMins")
    @Mapping(source = "hop", target = "hop")
    WarehouseNextHopsEntity fromDTO(WarehouseNextHops warehouseNextHops);

    @Mapping(source = "travelTimeMins", target = "travelTimeMins")
    @Mapping(source = "hop", target = "hop")
    WarehouseNextHops fromEntity(WarehouseNextHopsEntity entity);
}
