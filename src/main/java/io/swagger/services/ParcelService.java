package io.swagger.services;

import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;

public interface ParcelService {

    NewParcelInfo saveDomesticParcel(Parcel parcel);
    void reportParcelDelivery(String trackingId);
    TrackingInformation trackParcel(String trackingId);
    NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel);
    void reportParcelHop(String trackingId, String code);
}
