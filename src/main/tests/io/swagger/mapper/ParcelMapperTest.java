package io.swagger.mapper;

import io.swagger.businessLayer.mappers.ParcelMapper;
import io.swagger.businessLayer.mappers.RecipientMapper;
import io.swagger.dataAccessLayer.entities.ParcelDataAccessEntity;
import io.swagger.services.dto.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelMapperTest {

    @Test
    void testFrom() {

        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId("1234");

        Recipient recipient= new Recipient();
        recipient.setDummyData();
        Parcel parcel= new Parcel().weight(12.9f).sender(recipient).recipient(recipient);

        TrackingInformation trackingInformation= new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED).visitedHops(new ArrayList<HopArrival>()).futureHops(new ArrayList<HopArrival>());

        ParcelDataAccessEntity entity= ParcelMapper.from(newParcelInfo, parcel, trackingInformation);

        assertEquals(newParcelInfo.getTrackingId(), entity.getTrackingId());
        assert(parcel.getWeight()==entity.getWeight());
        assertEquals(parcel.getSender(), RecipientMapper.INSTANCE.fromEntity(entity.getSender()));
        assertEquals(parcel.getRecipient(), RecipientMapper.INSTANCE.fromEntity(entity.getRecipient()));
        assertEquals(trackingInformation.getState(), entity.getState());
        assertEquals(trackingInformation.getVisitedHops(), entity.getVisitedHops());
        assertEquals(trackingInformation.getFutureHops(), entity.getFutureHops());


    }
}