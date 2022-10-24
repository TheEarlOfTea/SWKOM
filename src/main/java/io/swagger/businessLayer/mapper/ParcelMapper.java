package io.swagger.businessLayer.mapper;

import io.swagger.businessLayer.entities.ParcelEntity;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {

    ParcelMapper INSTANCE= Mappers.getMapper(ParcelMapper.class);

    @Mapping(source="newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source="parcel.weight", target = "weight")
    @Mapping(source="parcel.recipient", target = "recipient")
    @Mapping(source="parcel.sender", target = "sender")
    @Mapping(source="trackingInformation.state", target = "state")
    @Mapping(source="trackingInformation.visitedHops", target = "visitedHops")
    @Mapping(source="trackingInformation.futureHops", target = "futureHops")
    ParcelEntity from(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation);


}
