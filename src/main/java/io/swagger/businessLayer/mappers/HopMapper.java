package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.HopDataAccessEntity;
import io.swagger.services.dto.Hop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopMapper {
    HopMapper INSTANCE= Mappers.getMapper(HopMapper.class);

    HopDataAccessEntity fromDTO(Hop hop);
    Hop fromEntity(HopDataAccessEntity entity);
}
