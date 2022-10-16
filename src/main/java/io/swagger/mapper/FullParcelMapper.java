package io.swagger.mapper;

import io.swagger.persistence.entity.FullParcelEntity;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FullParcelMapper {
    
    FullParcelMapper INSTANCE= Mappers.getMapper(FullParcelMapper.class);


    @Mapping(source="newParcelInfo.trackingId", target = "trackingId")
    @Mapping(source="parcel.weight", target = "weight")
    @Mapping(source="parcel.recipient", target = "recipient")
    @Mapping(source="parcel.sender", target = "sender")
    @Mapping(source="info.state", target = "state")
    @Mapping(source="info.visitedHops", target = "visitedHops")
    @Mapping(source="info.futureHops", target = "futureHops")
    FullParcelEntity from(NewParcelInfoEntity newParcelInfo, ParcelEntity parcel, TrackingInformation info);

}
