package io.swagger.mapper;

import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    ParcelEntity from(Parcel parcel);

}