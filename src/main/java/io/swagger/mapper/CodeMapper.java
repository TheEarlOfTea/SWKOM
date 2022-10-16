package io.swagger.mapper;

import io.swagger.persistence.entity.CodeEntity;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.services.dto.NewParcelInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CodeMapper {

    CodeMapper INSTANCE = Mappers.getMapper(CodeMapper.class);

    CodeEntity from(String code);



}
