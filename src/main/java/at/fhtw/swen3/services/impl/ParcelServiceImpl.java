package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.factories.TrackingInformationFactory;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {


    private ParcelRepository parcelRepository;
    private RecipientRepository recipientRepository;
    private HopArrivalRepository hopArrivalRepository;
    private HopRepository hopRepository;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopArrivalRepository hopArrivalRepository, HopRepository hopRepository) {
        this.parcelRepository = parcelRepository;
        this.recipientRepository = recipientRepository;
        this.hopArrivalRepository = hopArrivalRepository;
        this.hopRepository = hopRepository;
    }

    private void validateParcel(Parcel parcel) throws ValidationException{
        Validator.validate(parcel);
    }

    @Override
    public NewParcelInfo saveDomesticParcel(Parcel parcel) throws ValidationException, HttpClientErrorException {
        validateParcel(parcel);
        NewParcelInfo newParcelInfo= NewParcelInfoFactory.getNewParcelInfo();
        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);

    }

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) throws HttpClientErrorException{

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipientEntity(parcel.getRecipient()));
        entity.setSender(getRecipientEntity(parcel.getSender()));


        //check for existing hops
        for(HopArrival h: trackingInformation.getVisitedHops()){
            if(!doesHopExist(h.getCode())){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }
        for(HopArrival h: trackingInformation.getFutureHops()){
            if(!doesHopExist(h.getCode())){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }

        //save hopArrivals
        for(HopArrival h: trackingInformation.getVisitedHops()){
            hopArrivalRepository.save(HopArrivalMapper.INSTANCE.fromDTO(h));
        }
        for(HopArrival h: trackingInformation.getFutureHops()){
            hopArrivalRepository.save(HopArrivalMapper.INSTANCE.fromDTO(h));
        }

        parcelRepository.save(entity);
        return newParcelInfo;
    }

    private boolean doesHopExist(String code) {
        List<HopEntity> hopEntityList= hopRepository.findByCode(code);
        return hopEntityList.size()==1;
    }

    @Override
    public NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws ValidationException, HttpClientErrorException{
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        validateParcel(parcel);

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }

    private RecipientEntity getRecipientEntity(Recipient recipient){
        RecipientEntity recipientEntity= findRecipient(recipient);
        if(recipientEntity==null){
            recipientEntity= recipientRepository.save(RecipientMapper.INSTANCE.fromDTO(recipient));
        }
        return recipientEntity;
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
    public void reportParcelHop(String trackingId, String code) {

    }

    private RecipientEntity findRecipient(Recipient recipient) {
        ExampleMatcher matcher= ExampleMatcher.matching().withIgnorePaths("id");
        Optional<RecipientEntity> entity=recipientRepository.findOne(Example.of(RecipientMapper.INSTANCE.fromDTO(recipient), matcher));
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }


}
