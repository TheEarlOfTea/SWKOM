package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.services.dto.*;
import at.fhtw3.swen3.services.dto.*;
import org.junit.jupiter.api.Test;
import org.threeten.bp.OffsetDateTime;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    GeoCoordinate brokenCoordinate, correctCoordinate;
    Hop correctHop, brokenHop;
    HopArrival correctHopArrival, brokenHopArrival;
    NewParcelInfo correctNewParcelInfo, brokenNewParcelInfo;
    Parcel correctParcel, brokenParcel;
    TrackingInformation correctTrackingInfo, brokenTrackingInfo;
    Warehouse correctWarehouse, brokenWarehouse;
    Recipient correctRecipient, brokenRecipient;


    @Test
    void testCoordinateValidation(){
        brokenCoordinate= new GeoCoordinate();
        correctCoordinate= new GeoCoordinate();
        correctCoordinate.setLat(32.0);
        correctCoordinate.setLon(23.9);


        assertDoesNotThrow(() -> Validator.validate(correctCoordinate));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenCoordinate));
    }

    @Test
    void testHopValidation(){
        brokenHop= new Hop();
        correctHop= new Hop();
        correctHop.setHopType("test");
        correctHop.setCode("ABCD1234");
        correctHop.setDescription("ABCD");
        correctHop.setLocationCoordinates(new GeoCoordinate().lat(12.0).lon(12.0));
        correctHop.setProcessingDelayMins(1);
        correctHop.setLocationName("ABCD");

        assertDoesNotThrow(() -> Validator.validate(correctHop));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenHop));

    }

    @Test
    void testHopArrivalValidation(){
        brokenHopArrival=new HopArrival();
        correctHopArrival= new HopArrival();
        correctHopArrival.setCode("ABCD1234");
        correctHopArrival.setDescription("ABCD");
        correctHopArrival.setDateTime(OffsetDateTime.MAX);

        assertDoesNotThrow(() -> Validator.validate(correctHopArrival));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenHopArrival));
    }

    @Test
    void testNewParcelInfoValidation(){
        brokenNewParcelInfo= new NewParcelInfo();
        correctNewParcelInfo= new NewParcelInfo().trackingId("AAAAAAAAA");

        assertDoesNotThrow(() -> Validator.validate(correctNewParcelInfo));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenNewParcelInfo));
    }

    @Test
    void testParcelValidation(){
        brokenParcel= new Parcel();
        correctParcel= new Parcel();
        Recipient testRecipient= new Recipient();
        testRecipient.setDummyData();
        correctParcel.setRecipient(testRecipient);
        correctParcel.setSender(testRecipient);
        correctParcel.setWeight(12.9f);

        assertDoesNotThrow(() -> Validator.validate(correctParcel));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenParcel));
    }

    @Test
    void testWarehouseValidation(){
        brokenWarehouse= new Warehouse();
        correctWarehouse= new Warehouse();

        correctWarehouse.setHopType("test");
        correctWarehouse.setCode("ABCD1234");
        correctWarehouse.setDescription("ABCD");
        correctWarehouse.setLocationCoordinates(new GeoCoordinate().lat(12.0).lon(12.0));
        correctWarehouse.setProcessingDelayMins(1);
        correctWarehouse.setLocationName("ABCD");
        correctWarehouse.setLevel(1);
        correctWarehouse.setNextHops(new LinkedList<WarehouseNextHops>());

        assertDoesNotThrow(() -> Validator.validate(correctWarehouse));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenWarehouse));
    }

    @Test
    void testTrackingInfoValidation(){
        brokenTrackingInfo= new TrackingInformation();
        correctTrackingInfo= new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED).futureHops(new ArrayList<HopArrival>()).visitedHops(new ArrayList<HopArrival>());

        assertDoesNotThrow(() -> Validator.validate(correctTrackingInfo));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenTrackingInfo));
    }

    @Test
    void testRecipientValidation(){
        brokenRecipient= new Recipient();
        correctRecipient= new Recipient();
        correctRecipient.setDummyData();

        assertDoesNotThrow(() -> Validator.validate(correctRecipient));
        assertThrows(ValidationException.class, () -> Validator.validate(brokenRecipient));
    }
}