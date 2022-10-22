package io.swagger.mapper;

import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {

    @Test
    void testFrom() {

        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId("1234");

        Recipient recipient= new Recipient();
        recipient.setDummyData();
        Parcel parcel= new Parcel().weight(12.9f).sender(recipient).recipient(recipient);

        TrackingInformation trackingInformation= new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED).visitedHops(new ArrayList<HopArrival>()).futureHops(new ArrayList<HopArrival>());

        ParcelEntity entity= ParcelMapper.INSTANCE.from(newParcelInfo, parcel, trackingInformation);

        assertEquals(newParcelInfo.getTrackingId(), entity.getTrackingId());
        assert(parcel.getWeight()==entity.getWeight());
        assertEquals(parcel.getSender(), entity.getSender());
        assertEquals(parcel.getRecipient(), entity.getRecipient());
        assertEquals(trackingInformation.getState(), entity.getState());
        assertEquals(trackingInformation.getVisitedHops(), entity.getVisitedHops());
        assertEquals(trackingInformation.getFutureHops(), entity.getFutureHops());


    }
}