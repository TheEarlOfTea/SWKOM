package io.swagger.businessLayer.mappers;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import org.mapstruct.Mapper;

import java.util.LinkedList;

@Mapper
public class ParcelMapper {


    public static ParcelEntity from(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation){

        if ( newParcelInfo == null || parcel==null || trackingInformation==null ) {
            return null;
        }

        ParcelEntity entity= new ParcelEntity();
        entity.setTrackingId(newParcelInfo.getTrackingId());
        entity.setWeight(parcel.getWeight());
        entity.setRecipient(RecipientMapper.INSTANCE.fromDTO(parcel.getRecipient()));
        entity.setSender(RecipientMapper.INSTANCE.fromDTO(parcel.getSender()));
        entity.setState(trackingInformation.getState());
        entity.setFutureHops(new LinkedList<HopArrivalEntity>());
        entity.setVisitedHops(new LinkedList<HopArrivalEntity>());

        for(HopArrival a : trackingInformation.getFutureHops()){
            entity.getFutureHops().add(HopArrivalMapper.INSTANCE.fromDTO(a));
        }
        for(HopArrival a : trackingInformation.getVisitedHops()){
            entity.getVisitedHops().add(HopArrivalMapper.INSTANCE.fromDTO(a));
        }
        return entity;

    }


}
