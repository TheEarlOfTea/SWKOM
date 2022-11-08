package io.swagger.services.mapper;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper{
    ErrorMapper INSTANCE= Mappers.getMapper(ErrorMapper.class);

    ErrorEntity fromDTO(Error error);
    Error fromEntity(ErrorEntity entity);
}
