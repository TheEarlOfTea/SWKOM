package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.*;
import io.swagger.services.mapper.ParcelMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ParcelRepositoryTest {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    HopArrivalRepository hopArrivalRepository;
    @Autowired
    RecipientRepository recipientRepository;

    NewParcelInfo info;
    Parcel parcel;
    TrackingInformation trackingInformation;
    Recipient dummyRecipient;

    @BeforeEach
    void init() {
        parcelRepository.deleteAll();
        hopArrivalRepository.deleteAll();
        recipientRepository.deleteAll();
        info= new NewParcelInfo().trackingId("ABCD12345");
        parcel= new Parcel().weight(12.23f);
        dummyRecipient= new Recipient();
        dummyRecipient.setDummyData();
        parcel.setSender(dummyRecipient);
        parcel.setRecipient(dummyRecipient);
        trackingInformation= new TrackingInformation();
        trackingInformation.setState(TrackingInformation.StateEnum.DELIVERED);
        trackingInformation.setFutureHops(new LinkedList<HopArrival>());
        trackingInformation.setVisitedHops(new LinkedList<HopArrival>());
        trackingInformation.getVisitedHops().add(new HopArrival().code("ABCD12").dateTime(OffsetDateTime.MAX).description("SA"));
        trackingInformation.getFutureHops().add(new HopArrival().code("DDDD12").dateTime(OffsetDateTime.MAX).description("DA"));

    }

    @Test
    public void testSave() {


        ParcelEntity entity = ParcelMapper.INSTANCE.fromDTO(info, parcel, trackingInformation);
        recipientRepository.save(entity.getRecipient());
        recipientRepository.save(entity.getSender());
        for (HopArrivalEntity e : entity.getVisitedHops()) {
            hopArrivalRepository.save(e);
        }
        for (HopArrivalEntity e : entity.getFutureHops()) {
            hopArrivalRepository.save(e);
        }
        parcelRepository.save(entity);

        assertEquals(1, parcelRepository.count());
        assertEquals(2, recipientRepository.count());
        assertEquals(2, hopArrivalRepository.count());

    }
}