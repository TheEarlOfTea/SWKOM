package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelMapperTest {

    NewParcelInfo newParcelInfo;
    Recipient recipient;
    Parcel parcel;
    TrackingInformation trackingInformation;

    void setUp(){
        newParcelInfo= new NewParcelInfo().trackingId("1234");

        recipient= new Recipient();
        recipient.setDummyData();
        parcel= new Parcel().weight(12.9f).sender(recipient).recipient(recipient);

        trackingInformation= new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED).visitedHops(new ArrayList<HopArrival>()).futureHops(new ArrayList<HopArrival>());
        trackingInformation.addFutureHopsItem(new HopArrival().code("ABCD1234"));
        trackingInformation.addVisitedHopsItem(new HopArrival().code("ABCD1234"));
    }

    @Test
    void testFrom() {

        setUp();

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        assertEquals(newParcelInfo.getTrackingId(), entity.getTrackingId());
        assert(parcel.getWeight()==entity.getWeight());
        assertEquals(parcel.getSender(), RecipientMapper.INSTANCE.fromEntity(entity.getSender()));
        assertEquals(parcel.getRecipient(), RecipientMapper.INSTANCE.fromEntity(entity.getRecipient()));
        assertEquals(trackingInformation.getState(), entity.getState());
        assertEquals(trackingInformation.getVisitedHops().get(0), HopArrivalMapper.INSTANCE.fromEntity(entity.getVisitedHops().get(0)));
        assertEquals(trackingInformation.getFutureHops().get(0), HopArrivalMapper.INSTANCE.fromEntity(entity.getVisitedHops().get(0)));


    }
}