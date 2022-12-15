package at.fhtw3.swen3.services.mapper;

import at.fhtw3.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw3.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HopArrivalMapper {
    HopArrivalMapper INSTANCE= Mappers.getMapper(HopArrivalMapper.class);


    HopArrivalEntity fromDTO(HopArrival hopArrival);

    HopArrival fromEntity(HopArrivalEntity entity);
}
