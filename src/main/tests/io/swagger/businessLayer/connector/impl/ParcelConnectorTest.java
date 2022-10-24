package io.swagger.businessLayer.connector.impl;

import io.swagger.connector.impl.ParcelConnector;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.Recipient;
import junit.framework.TestCase;
import org.mockito.Mockito;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParcelConnectorTest extends TestCase {

    Parcel goodParcel;
    Parcel badParcel;
    String goodTrackingId="123456789";
    String badTrackingId="1";
    String goodCode="ABCD1";
    String badCode="A";

    ParcelConnector connector= new ParcelConnector();

    void initializeParcels(){
        goodParcel= new Parcel();
        goodParcel.setWeight(10.0f);
        Recipient testRecipient= new Recipient();
        testRecipient.setDummyData();
        goodParcel.setSender(testRecipient);
        goodParcel.setRecipient(testRecipient);

        badParcel= Mockito.mock(Parcel.class);
    }


    public void testSubmitParcel() {
        initializeParcels();

        assertDoesNotThrow(() -> connector.submitParcel(goodParcel));
        assertThrows(ValidationException.class, () -> connector.submitParcel(badParcel));
    }

    public void testTrackParcel() {
        assertDoesNotThrow(() -> connector.trackParcel(goodTrackingId));
        assertThrows(ValidationException.class, () -> connector.trackParcel(badTrackingId));
    }

    public void testSubmitTransitionParcel() {
        initializeParcels();

        assertDoesNotThrow(() -> connector.submitTransitionParcel(goodTrackingId, goodParcel));
        assertThrows(ValidationException.class, () -> connector.submitTransitionParcel(badTrackingId, goodParcel));
        assertThrows(ValidationException.class, () -> connector.submitTransitionParcel(goodTrackingId, badParcel));
        assertThrows(ValidationException.class, () -> connector.submitTransitionParcel(badTrackingId, badParcel));
    }

    public void testReportParcelDelivery() {
        assertDoesNotThrow(() -> connector.reportParcelDelivery(goodTrackingId));
        assertThrows(ValidationException.class, () -> connector.reportParcelDelivery(badTrackingId));
    }

    public void testReportParcelHop() {
        assertDoesNotThrow(() -> connector.reportParcelHop(goodTrackingId, goodCode));
        assertThrows(ValidationException.class, () -> connector.reportParcelHop(badTrackingId, goodCode));
        assertThrows(ValidationException.class, () -> connector.reportParcelHop(goodTrackingId, badCode));
        assertThrows(ValidationException.class, () -> connector.reportParcelHop(badTrackingId, badCode));
    }
}