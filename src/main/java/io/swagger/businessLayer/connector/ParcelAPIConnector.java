package io.swagger.businessLayer.connector;

import io.swagger.services.dto.Parcel;

public interface ParcelAPIConnector {
    public void submitParcel(Parcel parcel);
    public void trackParcel(String trackingId);
    public void submitTransitionParcel(String trackingId, Parcel parcel);
    public void reportParcelDelivery(String trackingId);
    public void reportParcelHop(String trackingId, String code);
}
