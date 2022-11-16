package io.swagger.services.mapper;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson")
    @Mapping(source = "logisticsPartner", target = "logisticsPartner")
    @Mapping(source = "logisticsPartnerUrl", target = "logisticsPartnerUrl")
    TransferwarehouseEntity fromDTO(Transferwarehouse transferwarehouse);
    @Mapping(source = "hopType", target = "hopType")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "processingDelayMins", target = "processingDelayMins")
    @Mapping(source = "locationName", target = "locationName")
    @Mapping(source = "locationCoordinates", target = "locationCoordinates")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson")
    @Mapping(source = "logisticsPartner", target = "logisticsPartner")
    @Mapping(source = "logisticsPartnerUrl", target = "logisticsPartnerUrl")
    Transferwarehouse fromEntity(TransferwarehouseEntity entity);
}
