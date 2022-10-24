package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.HopBusinessEntity;
import io.swagger.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE= Mappers.getMapper(HopMapper.class);

    HopBusinessEntity fromDTO(Hop hop);
    Hop fromEntity(HopBusinessEntity entity);
}
