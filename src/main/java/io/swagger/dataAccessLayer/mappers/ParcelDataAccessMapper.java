package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.ParcelBusinessEntity;
import io.swagger.dataAccessLayer.entities.ParcelDataAccessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelDataAccessMapper {
    ParcelDataAccessMapper INSTANCE= Mappers.getMapper(ParcelDataAccessMapper.class);

    ParcelDataAccessEntity fromBusinessEntity(ParcelBusinessEntity businessEntity);
    ParcelBusinessEntity fromDataAccessEntity(ParcelDataAccessEntity dataAccessEntity);
}
