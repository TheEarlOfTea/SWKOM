package io.swagger.businessLayer.mappers;

import io.swagger.dataAccessLayer.entities.ParcelDataAccessEntity;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


//todo: parcel mapper anpassen, recipient auf recipiententity

@Mapper
public class ParcelMapper {


    public static ParcelDataAccessEntity from(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation){

        if ( newParcelInfo == null || parcel==null || trackingInformation==null ) {
            return null;
        }

        ParcelDataAccessEntity entity= new ParcelDataAccessEntity();
        entity.setTrackingId(newParcelInfo.getTrackingId());
        entity.setWeight(parcel.getWeight());
        entity.setRecipient(RecipientMapper.INSTANCE.fromDTO(parcel.getRecipient()));
        entity.setSender(RecipientMapper.INSTANCE.fromDTO(parcel.getSender()));
        entity.setState(trackingInformation.getState());
        return entity;

    }


}
