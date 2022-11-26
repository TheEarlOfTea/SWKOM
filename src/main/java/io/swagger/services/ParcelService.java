package io.swagger.services;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.Parcel;

import java.util.List;

public interface ParcelService {

    void save(ParcelEntity entity);
    List<Parcel> findAll();
    void deleteById(long id);
    Parcel getById(long id);
    Parcel findByTrackingId(String trackingId);

}
