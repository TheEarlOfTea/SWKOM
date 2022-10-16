package io.swagger.mapper;

import io.swagger.model.HopArrival;
import io.swagger.model.Recipient;
import io.swagger.persistence.entity.FullParcelEntity;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import junit.framework.TestCase;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class FullParcelMapperTest extends TestCase {

    private static NewParcelInfo newParcelInfo= new NewParcelInfo();
    private static Parcel parcel= new Parcel();
    private static TrackingInformation trackingInformation= new TrackingInformation();

    private static NewParcelInfoEntity newParcelInfoEntity;
    private static ParcelEntity parcelEntity;

    @BeforeAll
    public static void setup(){

        newParcelInfo.setTrackingId("test");

        newParcelInfoEntity= NewParcelInfoMapper.INSTANCE.from(newParcelInfo);

        parcel.setWeight(25.3f);
        parcel.setRecipient(Mockito.mock(Recipient.class));
        parcel.setSender(Mockito.mock(Recipient.class));

        parcelEntity= ParcelMapper.INSTANCE.from(parcel);

        trackingInformation.setState(TrackingInformation.StateEnum.DELIVERED);
        trackingInformation.addVisitedHopsItem(Mockito.mock(HopArrival.class));
        trackingInformation.addFutureHopsItem(Mockito.mock(HopArrival.class));

    }
    @Test
    @DisplayName("tests from method")
    public void testFrom() {

        FullParcelEntity entity= FullParcelMapper.INSTANCE.from(newParcelInfoEntity, parcelEntity, trackingInformation);

        assertEquals(newParcelInfo.getTrackingId(), entity.getTrackingId());
        //assert(parcel.getWeight()==entity.getWeight());
        assertEquals(parcel.getSender(), entity.getSender());
        assertEquals(parcel.getRecipient(), entity.getRecipient());

        assertEquals(trackingInformation.getState(), entity.getState());
        assertEquals(trackingInformation.getVisitedHops(), entity.getVisitedHops());
        assertEquals(trackingInformation.getFutureHops(), entity.getFutureHops());
    }
}