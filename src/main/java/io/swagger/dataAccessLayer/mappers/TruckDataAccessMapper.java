package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.TruckBusinessEntity;
import io.swagger.dataAccessLayer.entities.TruckDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TruckDataAccessMapper {
    TruckDataAccessMapper INSTANCE= Mappers.getMapper(TruckDataAccessMapper.class);

    TruckDataAccessEntity fromBusinessEntity(TruckBusinessEntity businessEntity);
    TruckBusinessEntity fromDataAccessEntity(TruckDataAccessEntity dataAccessEntity);
}
