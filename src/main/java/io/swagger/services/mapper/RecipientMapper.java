package io.swagger.services.mapper;

import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.services.dto.Recipient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipientMapper {
    RecipientMapper INSTANCE= Mappers.getMapper(RecipientMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "street", target = "street")
    @Mapping(source = "postalCode", target = "postalCode")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "country", target = "country")
    RecipientEntity fromDTO(Recipient recipient);
    Recipient fromEntity(RecipientEntity entity);
}
