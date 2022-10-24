package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.RecipientBusinessEntity;
import io.swagger.services.dto.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE= Mappers.getMapper(RecipientMapper.class);

    RecipientBusinessEntity fromDTO(Recipient recipient);
    Recipient fromEntity(RecipientBusinessEntity entity);
}
