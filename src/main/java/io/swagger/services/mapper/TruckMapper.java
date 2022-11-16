package io.swagger.services.mapper;

import io.swagger.persistence.entities.TruckEntity;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);


    TruckEntity fromDTO(Truck hop);

    Truck fromEntity(TruckEntity entity);
}
