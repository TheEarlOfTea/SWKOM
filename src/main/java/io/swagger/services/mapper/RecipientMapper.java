package io.swagger.services.mapper;

import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE= Mappers.getMapper(RecipientMapper.class);

    RecipientEntity fromDTO(Recipient recipient);

    Recipient fromEntity(RecipientEntity entity);
}
