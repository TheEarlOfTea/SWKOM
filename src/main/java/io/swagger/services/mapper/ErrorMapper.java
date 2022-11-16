package io.swagger.services.mapper;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper{
    ErrorMapper INSTANCE= Mappers.getMapper(ErrorMapper.class);

    @Mapping(source = "errorMessage", target = "errorMessage")
    ErrorEntity fromDTO(Error error);
    @Mapping(source = "errorMessage", target = "errorMessage")
    Error fromEntity(ErrorEntity entity);
}
