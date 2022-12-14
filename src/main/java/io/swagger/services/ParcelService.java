package io.swagger.services;

import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;

import java.util.List;

public interface ParcelService {

    void saveParcel(Parcel parcel);
    List<Parcel> findAllParcels();
    void deleteParcelById(long id);
    Parcel getParcelById(long id);
    Parcel findByTrackingId(String trackingId);

}
