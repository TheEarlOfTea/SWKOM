package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.RecipientBusinessEntity;
import io.swagger.dataAccessLayer.entities.RecipientDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RecipientDataAccessMapper {
    RecipientDataAccessMapper INSTANCE= Mappers.getMapper(RecipientDataAccessMapper.class);

    RecipientDataAccessEntity fromBusinessEntity(RecipientBusinessEntity businessEntity);
    RecipientBusinessEntity fromDataAcessEntity(RecipientDataAccessEntity dataAccessEntity);
}
