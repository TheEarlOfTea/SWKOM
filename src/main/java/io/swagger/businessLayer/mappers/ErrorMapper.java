package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.ErrorBusinessEntity;
import io.swagger.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper{
    ErrorMapper INSTANCE= Mappers.getMapper(ErrorMapper.class);

    ErrorBusinessEntity fromDTO(Error error);
    Error fromEntity(ErrorBusinessEntity entity);
}
