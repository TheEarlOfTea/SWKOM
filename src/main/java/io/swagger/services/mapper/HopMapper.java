package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE= Mappers.getMapper(HopMapper.class);

    HopEntity fromDTO(Hop hop);
    Hop fromEntity(HopEntity entity);
}
