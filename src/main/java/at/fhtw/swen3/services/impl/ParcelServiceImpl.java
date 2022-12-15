package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.factories.TrackingInformationFactory;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.HopArrivalService;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;
import java.util.LinkedList;
import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private RecipientService recipientService;
    @Autowired
    private HopArrivalService hopArrivalService;

    private void validateParcel(Parcel parcel) throws ValidationException{
        Validator.validate(parcel);
    }

    private RecipientEntity getRecipientEntity(Recipient recipient){
        RecipientEntity recipientEntity= recipientService.findRecipient(recipient);
        if(recipientEntity==null){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        return recipientEntity;
    }

    private List<HopArrivalEntity> getHopArrivalEntities(List<HopArrival> list) throws HttpClientErrorException{
        LinkedList<HopArrivalEntity> newList= new LinkedList<HopArrivalEntity>();
        HopArrivalEntity currentHop;
        for(HopArrival h : list){
            currentHop= hopArrivalService.findHopArrival(h);
            if(currentHop==null){
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
            }
            newList.add(currentHop);
        }
        return newList;
    }

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) throws HttpClientErrorException{

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipientEntity(parcel.getRecipient()));
        entity.setSender(getRecipientEntity(parcel.getSender()));

        //check for existing HopArrivals
        entity.setVisitedHops(getHopArrivalEntities(trackingInformation.getVisitedHops()));
        entity.setFutureHops(getHopArrivalEntities(trackingInformation.getFutureHops()));

        parcelRepository.save(entity);
        return newParcelInfo;
    }

    @Override
    public NewParcelInfo saveDomesticParcel(Parcel parcel) throws ValidationException, HttpClientErrorException {
        validateParcel(parcel);
        NewParcelInfo newParcelInfo= NewParcelInfoFactory.getNewParcelInfo();
        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);

    }

    @Override
    public void reportParcelDelivery(String trackingId) throws ValidationException, HttpClientErrorException {

        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        ParcelEntity entity;
        try{
            entity= parcelRepository.findByTrackingId(trackingId).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        entity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(entity);

    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws ValidationException, HttpClientErrorException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        ParcelEntity entity;
        try{
            entity= parcelRepository.findByTrackingId(trackingId).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return ParcelMapper.INSTANCE.trackingInformationFromEntity(entity);
    }

    @Override
    public NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws ValidationException, HttpClientErrorException{
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        validateParcel(parcel);

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }

    @Override
    public void reportParcelHop(String trackingId, String code) {

    }


}
