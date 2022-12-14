package io.swagger.services.mapper;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface ParcelMapper {

    ParcelMapper INSTANCE= Mappers.getMapper(ParcelMapper.class);

    @Named("hopArrivalListDtoToEntity")
    public static List<HopArrivalEntity> hopArrivalListDtoToEntity(List<HopArrival> list){
        LinkedList<HopArrivalEntity> newList= new LinkedList<HopArrivalEntity>();

        for(HopArrival i : list){
            newList.add(HopArrivalMapper.INSTANCE.fromDTO(i));
        }
        return newList;
    }

    @Named("hopArrivalListEntityToDto")
    public static List<HopArrival> hopArrivalListEntityToDto(List<HopArrivalEntity> list){
        LinkedList<HopArrival> newList= new LinkedList<HopArrival>();

        for(HopArrivalEntity i : list){
            newList.add(HopArrivalMapper.INSTANCE.fromEntity(i));
        }
        return newList;
    }

    @Mapping(source = "info.trackingId", target = "trackingId")
    @Mapping(source = "parcel.weight", target = "weight")
    @Mapping(source = "parcel.recipient", target = "recipient")
    @Mapping(source = "parcel.sender", target = "sender")
    @Mapping(source = "trackingInformation.state.", target = "state")
    @Mapping(source = "trackingInformation.visitedHops", target = "visitedHops", qualifiedByName = "hopArrivalListDtoToEntity")
    @Mapping(source = "trackingInformation.futureHops", target = "futureHops", qualifiedByName = "hopArrivalListDtoToEntity")
    ParcelEntity fromDTO(NewParcelInfo info, Parcel parcel, TrackingInformation trackingInformation);


    @Mapping(source = "entity.weight", target = "weight")
    @Mapping(source = "entity.recipient", target = "recipient")
    @Mapping(source = "entity.sender", target = "sender")
    Parcel fromEntity(ParcelEntity entity);
}
