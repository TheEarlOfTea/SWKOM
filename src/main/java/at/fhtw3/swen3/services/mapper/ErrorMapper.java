package at.fhtw3.swen3.services.mapper;

import at.fhtw3.swen3.persistence.entities.ErrorEntity;
import at.fhtw3.swen3.services.dto.Error;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ErrorMapper{
    ErrorMapper INSTANCE= Mappers.getMapper(ErrorMapper.class);

    ErrorEntity fromDTO(Error error);
    Error fromEntity(ErrorEntity entity);
}
