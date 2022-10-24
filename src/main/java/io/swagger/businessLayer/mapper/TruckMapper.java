package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.HopEntity;
import io.swagger.businessLayer.entities.TruckEntity;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    TruckEntity fromDTO(Truck hop);
    Truck fromEntity(TruckEntity entity);
}
