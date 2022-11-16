package io.swagger.services.impl;



import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.repositories.ParcelRepository;
import io.swagger.services.ParcelService;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import io.swagger.services.mapper.ParcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class ParcelServiceImpl implements ParcelService{

    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private ParcelMapper parcelMapper;


    //nicht sicher
    private io.swagger.services.dto.NewParcelInfo NewParcelInfo;
    private io.swagger.services.dto.Parcel Parcel;
    private Object TrackingInformation;


    // Save operation
    @Override
    public ParcelEntity saveParcelEntity(Parcel parcel) {
        return parcelRepository.save(parcelMapper.from(NewParcelInfo,Parcel,TrackingInformation)); // bei 3 Parameters - problem
    }


    @Override
    public List<Parcel> fetchParcelEntityList() {
        return null;
    }


    @Override
    public void getAllParcelEntity(Parcel parcel) {

    }

    @Override
    public void findParcelEntityByIdAll(Long parcelId) {

    }


    // Delete operation
    @Override
    public void deleteParcelEntityById(Long Id){
        parcelRepository.deleteById(Id);
    }








}
