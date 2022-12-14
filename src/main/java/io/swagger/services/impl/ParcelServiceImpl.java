package io.swagger.services.impl;

import io.swagger.factories.NewParcelInfoFactory;
import io.swagger.factories.TrackingInformationFactory;
import io.swagger.persistence.entities.HopArrivalEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.entities.RecipientEntity;
import io.swagger.persistence.repositories.HopArrivalRepository;
import io.swagger.persistence.repositories.ParcelRepository;
import io.swagger.persistence.repositories.RecipientRepository;
import io.swagger.services.HopArrivalService;
import io.swagger.services.ParcelService;
import io.swagger.services.RecipientService;
import io.swagger.services.dto.*;
import io.swagger.services.mapper.HopArrivalMapper;
import io.swagger.services.mapper.ParcelMapper;
import io.swagger.services.mapper.RecipientMapper;
import io.swagger.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private RecipientService recipientService;
    @Autowired
    private HopArrivalService hopArrivalService;

    @Override
    public void saveParcel(Parcel parcel) throws ValidationException {
        Validator.validate(parcel);
        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(NewParcelInfoFactory.getNewParcelInfo(),parcel, trackingInformation);

        entity.setSender(recipientService.saveRecipient(parcel.getSender()));
        entity.setRecipient(recipientService.saveRecipient(parcel.getRecipient()));

        entity.setVisitedHops(hopArrivalService.saveMultipleHopArrivals(trackingInformation.getVisitedHops()));
        entity.setFutureHops(hopArrivalService.saveMultipleHopArrivals(trackingInformation.getFutureHops()));

        parcelRepository.save(entity);
    }

    @Override
    public List<Parcel> findAllParcels() {
        List<ParcelEntity> list= parcelRepository.findAll();
        LinkedList<Parcel> returnList= new LinkedList<Parcel>();
        for(ParcelEntity e: list){
            returnList.add(ParcelMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteParcelById(long id) {
        parcelRepository.deleteById(id);
    }

    @Override
    public Parcel getParcelById(long id) {

        Optional<ParcelEntity> entity= parcelRepository.findById(id);
        if(entity.isPresent()){
            return ParcelMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }

    @Override
    public Parcel findByTrackingId(String trackingId) {
        try {
            ParcelEntity entity= parcelRepository.findByTrackingId(trackingId).get(0);
            return ParcelMapper.INSTANCE.fromEntity(entity);
        }catch (IndexOutOfBoundsException e){

        }
        return null;
    }
}
