package io.swagger.businessLayer.connector.impl;

import io.swagger.model.Recipient;
import io.swagger.services.dto.Parcel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ParcelConnectorTest extends TestCase {

    Parcel goodParcel;
    Parcel badParcel;
    String goodTrackingId;
    String badTrackingId;
    String goodCode;
    String badCode;

    ParcelConnector connector;

    void initialize(){
        goodParcel= new Parcel();
        goodParcel.setWeight(10.0f);
        goodParcel.setSender(Mockito.mock(Recipient.class));
        goodParcel.setRecipient(Mockito.mock(Recipient.class));

        badParcel= Mockito.mock(Parcel.class);

        goodTrackingId="123456789";
        badTrackingId="1";
        goodCode="ABCD1";
        badCode="A";

        connector= new ParcelConnector();
    }

    public void testSubmitParcel() {
        initialize();
        assert(connector.submitParcel(goodParcel));
        assertFalse(connector.submitParcel(badParcel));
    }

    public void testTrackParcel() {
        initialize();
        assert(connector.trackParcel(goodTrackingId));
        assertFalse(connector.trackParcel(badTrackingId));
    }

    public void testSubmitTransitionParcel() {
        initialize();
        assert(connector.submitTransitionParcel(goodTrackingId,goodParcel));
        assertFalse(connector.submitTransitionParcel(badTrackingId, goodParcel));
        assertFalse(connector.submitTransitionParcel(goodTrackingId, badParcel));
        assertFalse(connector.submitTransitionParcel(badTrackingId,badParcel));
    }

    public void testReportParcelDelivery() {
        initialize();
        assert(connector.reportParcelDelivery(goodTrackingId));
        assertFalse(connector.reportParcelDelivery(badTrackingId));
    }

    public void testReportParcelHop() {
        initialize();
        assert connector.reportParcelHop(goodTrackingId, goodCode);
        assertFalse(connector.reportParcelHop(goodTrackingId, badCode));
        assertFalse(connector.reportParcelHop(badTrackingId, goodCode));
        assertFalse(connector.reportParcelHop(badTrackingId, badCode));
    }
}