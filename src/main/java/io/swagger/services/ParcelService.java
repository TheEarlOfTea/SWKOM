package io.swagger.services;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.Parcel;

import java.util.List;

public interface ParcelService {
    // Save operation
    ParcelEntity saveParcelEntity(Parcel parcel);

    // Read operation
    List<Parcel> fetchParcelEntityList();

    //getAll
    void getAllParcelEntity(Parcel parcel);

    //getAll
    void findParcelEntityByIdAll(Long parcelId);

    // Delete operation
    void deleteParcelEntityById(Long parcelId);

}
