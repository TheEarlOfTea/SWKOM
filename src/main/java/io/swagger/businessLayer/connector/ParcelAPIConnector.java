package io.swagger.businessLayer.connector;

import io.swagger.services.dto.Parcel;

public interface ParcelAPIConnector {
    public boolean submitParcel(Parcel parcel);
    public boolean trackParcel(String trackingId);
    public boolean submitTransitionParcel(String trackingId, Parcel parcel);
    public boolean reportParcelDelivery(String trackingId);
    public boolean reportParcelHop(String trackingId, String code);
}
