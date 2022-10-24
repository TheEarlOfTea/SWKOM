package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.ErrorBusinessEntity;
import io.swagger.dataAccessLayer.entities.ErrorDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorDataAccessMapper {
    ErrorDataAccessMapper INSTANCE= Mappers.getMapper(ErrorDataAccessMapper.class);

    ErrorDataAccessEntity fromBusinessEntity(ErrorBusinessEntity businessEntity);
    ErrorBusinessEntity fromDataAccessEntity(ErrorDataAccessEntity dataAccessEntity);


}
