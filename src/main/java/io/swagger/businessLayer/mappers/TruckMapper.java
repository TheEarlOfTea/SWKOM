package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.TruckBusinessEntity;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    TruckBusinessEntity fromDTO(Truck hop);
    Truck fromEntity(TruckBusinessEntity entity);
}
