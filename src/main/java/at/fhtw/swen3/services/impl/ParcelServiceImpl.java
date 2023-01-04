package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.factories.TrackingInformationFactory;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadParcelDataException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadTrackingIdException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.ParcelNotFoundException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {


    private final ParcelRepository parcelRepository;
    private final RecipientRepository recipientRepository;
    private final HopArrivalRepository hopArrivalRepository;
    private final HopRepository hopRepository;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopArrivalRepository hopArrivalRepository, HopRepository hopRepository) {
        this.parcelRepository = parcelRepository;
        this.recipientRepository = recipientRepository;
        this.hopArrivalRepository = hopArrivalRepository;
        this.hopRepository = hopRepository;
    }





    @Override
    public NewParcelInfo saveDomesticParcel(Parcel parcel) throws BadParcelDataException {
        try{
            Validator.validate(parcel);
        }catch (ValidationException e){
            log.error("Parcel failed validation. " + e.getMessage());
            throw new BadParcelDataException("Parcel received failed validation. Please validate parcel data and try again. Validaation error: " + e.getMessage());
        }

        NewParcelInfo newParcelInfo= NewParcelInfoFactory.getNewParcelInfo();
        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);

    }

    @Override
    public NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws BadParcelDataException, BadTrackingIdException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);

        try{
            Validator.validate(newParcelInfo);
        }catch (ValidationException e){
            log.error("Tracking-Id failed validation. " + e.getMessage());
            throw new BadTrackingIdException("Tracking-Id received does not conform with our UUID standards.");
        }

        try{
            Validator.validate(parcel);
        }catch (ValidationException e){
            log.error("Parcel received failed validation. ValidationException: " + e.getMessage());
            throw new BadParcelDataException("Parcel received failed validation. Please validate parcel data and try again. Validation error: " + e.getMessage());
        }

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }


    @Override
    public void reportParcelDelivery(String trackingId) throws BadTrackingIdException, ParcelNotFoundException {

        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        try{
            Validator.validate(newParcelInfo);
        }catch (ValidationException e){
            log.error("Tracking-Id failed validation. " + e.getMessage());
            throw new BadTrackingIdException("Tracking-Id received does not conform with our UUID standards.");
        }

        ParcelEntity entity;
        try {
            entity = getParcelEntity(trackingId);
        } catch (ParcelNotFoundException e) {
            log.error("Invalid Tracking-Id given by user. Parcel with given TrackingId " + trackingId + " could not be found");
            throw new ParcelNotFoundException("Parcel with Tracking-Id " + trackingId + " could not be found. Please validate Tracking-Id and try again");
        }

        entity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(entity);

    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws BadTrackingIdException, ParcelNotFoundException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        try{
            Validator.validate(newParcelInfo);
        }catch (ValidationException e){
            log.error("Tracking-Id failed validation. " + e.getMessage());
            throw new BadTrackingIdException("Tracking-Id received does not conform with our UUID standards.");
        }

        ParcelEntity entity;
        try {
            entity = getParcelEntity(trackingId);
        } catch (ParcelNotFoundException e) {
            log.error("Invalid Tracking-Id given by user. Parcel with given TrackingId " + trackingId + " could not be found");
            throw new ParcelNotFoundException("Parcel with Tracking-Id " + trackingId + " could not be found. Please validate Tracking-Id and try again");
        }

        return ParcelMapper.INSTANCE.trackingInformationFromEntity(entity);
    }



    @Override
    @Transactional
    public void reportParcelHop(String trackingId, String code) throws BadTrackingIdException, ParcelNotFoundException, HopNotFoundException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        try{
            Validator.validate(newParcelInfo);
        }catch (ValidationException e){
            log.error("Tracking-Id failed validation. " + e.getMessage());
            throw new BadTrackingIdException("Tracking-Id received does not conform with our UUID standards.");
        }

        ParcelEntity parcelEntity;
        try {
            parcelEntity = getParcel(trackingId);
        } catch (ParcelNotFoundException e) {
            log.error("Invalid Tracking-Id given by user. Parcel with given TrackingId " + trackingId + " could not be found");
            throw new ParcelNotFoundException("Parcel with Tracking-Id " + trackingId + " could not be found. Please validate Tracking-Id and try again");
        }

        String hopType;
        try {
            hopType = getHopType(code);
        } catch (HopNotFoundException e) {
            log.error(e.getMessage());
            throw new HopNotFoundException("Hop with code " + code + " could not be found. Please validate code and try again");
        }

        switch (hopType){
            case "truck":
                parcelEntity.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
            case "warehouse":
                parcelEntity.setState(TrackingInformation.StateEnum.INTRANSPORT);
            case "transferwarehouse":
                parcelEntity.setState(TrackingInformation.StateEnum.TRANSFERRED);
        }

        parcelEntity.getVisitedHops().add(parcelEntity.getFutureHops().remove(0));
        parcelRepository.save(parcelEntity);

    }

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) {

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipient(parcel.getRecipient()));
        entity.setSender(getRecipient(parcel.getSender()));


        //probably unnecessary, due to trackinginformation not beeing user input
        /*for(HopArrival h: trackingInformation.getVisitedHops()){
            if(!doesHopExist(h.getCode())){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }
        for(HopArrival h: trackingInformation.getFutureHops()){
            if(!doesHopExist(h.getCode())){
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            }
        }*/

        //save hopArrivals
        for(HopArrivalEntity h: entity.getVisitedHops()){
            h=hopArrivalRepository.save(h);
        }
        for(HopArrivalEntity h: entity.getFutureHops()){
            h=hopArrivalRepository.save(h);
        }

        parcelRepository.save(entity);
        return newParcelInfo;
    }


    private boolean doesHopExist(String code) {
        return hopRepository.existsByCode(code);
    }

    private ParcelEntity getParcel(String trackingId) throws ParcelNotFoundException{
        ParcelEntity parcelEntity;
        try{
            parcelEntity= parcelRepository.findByTrackingId(trackingId).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new ParcelNotFoundException("Parcel with given trackingId " + trackingId + " does not exist");
        }
        return parcelEntity;
    }

    private ParcelEntity getParcelEntity(String trackingId) throws ParcelNotFoundException{
        ParcelEntity entity;
        try {
            entity = getParcel(trackingId);
        } catch (ParcelNotFoundException e) {
            log.error(e.getMessage());
            throw e;
        }
        return entity;
    }

    private RecipientEntity getRecipient(Recipient recipient){
        RecipientEntity recipientEntity= findRecipient(recipient);
        if(recipientEntity==null){
            recipientEntity= recipientRepository.save(RecipientMapper.INSTANCE.fromDTO(recipient));
        }
        return recipientEntity;
    }

    protected String getHopType(String code) throws HopNotFoundException {
        if(doesHopExist(code)){
            return hopRepository.getHoptypeByCode(code).get();
        }
        throw new HopNotFoundException("Hop with code " + code + " does not exist.");

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
