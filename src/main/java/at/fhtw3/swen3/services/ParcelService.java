package at.fhtw3.swen3.services;

import at.fhtw3.swen3.services.dto.NewParcelInfo;
import at.fhtw3.swen3.services.dto.Parcel;
import at.fhtw3.swen3.services.dto.TrackingInformation;

public interface ParcelService {

    NewParcelInfo saveDomesticParcel(Parcel parcel);
    void reportParcelDelivery(String trackingId);
    TrackingInformation trackParcel(String trackingId);
    NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel);
    void reportParcelHop(String trackingId, String code);
}
