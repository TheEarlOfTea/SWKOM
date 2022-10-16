package io.swagger.mapper;

import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.services.dto.NewParcelInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewParcelInfoMapper {

    NewParcelInfoMapper INSTANCE = Mappers.getMapper(NewParcelInfoMapper.class);

    NewParcelInfoEntity from(NewParcelInfo info);
    NewParcelInfoEntity from(String trackingId);

}
