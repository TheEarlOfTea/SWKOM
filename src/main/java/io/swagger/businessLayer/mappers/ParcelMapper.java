package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.ParcelDataAccessEntity;
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
    ParcelDataAccessEntity from(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation);


}
