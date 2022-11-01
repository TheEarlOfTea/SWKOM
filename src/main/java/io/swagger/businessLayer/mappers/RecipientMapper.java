package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.RecipientDataAccessEntity;
import io.swagger.services.dto.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE= Mappers.getMapper(RecipientMapper.class);

    RecipientDataAccessEntity fromDTO(Recipient recipient);
    Recipient fromEntity(RecipientDataAccessEntity entity);
}
