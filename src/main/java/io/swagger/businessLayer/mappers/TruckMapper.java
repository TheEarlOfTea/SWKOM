package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.TruckDataAccessEntity;
import io.swagger.services.dto.Truck;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckMapper {

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    TruckDataAccessEntity fromDTO(Truck hop);
    Truck fromEntity(TruckDataAccessEntity entity);
}
