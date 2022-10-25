package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.ErrorDataAccessEntity;
import io.swagger.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper{
    ErrorMapper INSTANCE= Mappers.getMapper(ErrorMapper.class);

    ErrorDataAccessEntity fromDTO(Error error);
    Error fromEntity(ErrorDataAccessEntity entity);
}
