package io.swagger.services;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Parcel;

import java.util.List;

public interface ParcelService {

    void save(Parcel parcel);
    List<Parcel> findAll();
    void deleteById(long id);
    Parcel getById(long id);

}
