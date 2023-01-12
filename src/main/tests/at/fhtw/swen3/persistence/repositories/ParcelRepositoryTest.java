package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ParcelRepositoryTest {

    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    RecipientRepository recipientRepository;

    NewParcelInfo info;
    Parcel parcel;
    TrackingInformation trackingInformation;
    Recipient dummyRecipient;

    @BeforeEach
    void init() {
        info= NewParcelInfoFactory.getNewParcelInfo();
        parcel= new Parcel().weight(12.23f);
        dummyRecipient= new Recipient();
        dummyRecipient.setDummyData();
        parcel.setSender(dummyRecipient);
        parcel.setRecipient(dummyRecipient);
        trackingInformation= new TrackingInformation();
        trackingInformation.setState(TrackingInformation.StateEnum.DELIVERED);
        trackingInformation.setFutureHops(new LinkedList<HopArrival>());
        trackingInformation.setVisitedHops(new LinkedList<HopArrival>());

    }

    @Test
    public void testDB() {

        ParcelEntity parcelEntity= ParcelMapper.INSTANCE.fromDTO(info, parcel, trackingInformation);

        RecipientEntity recipientEntity= recipientRepository.save(parcelEntity.getRecipient());
        parcelEntity.setRecipient(recipientEntity);
        parcelEntity.setSender(recipientEntity);

        parcelEntity= parcelRepository.save(parcelEntity);

        Optional<RecipientEntity> optionalRecipientEntity= recipientRepository.findById(recipientEntity.getId());
        Optional<ParcelEntity> optionalParcelEntity= parcelRepository.findById(parcelEntity.getId());

        assert(optionalParcelEntity.isPresent());
        assert(optionalRecipientEntity.isPresent());

        parcelRepository.delete(parcelEntity);
        recipientRepository.delete(recipientEntity);


    }
}