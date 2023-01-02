package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.factories.TrackingInformationFactory;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
public class ParcelServiceImpl implements ParcelService {


    private ParcelRepository parcelRepository;
    private RecipientRepository recipientRepository;
    private HopArrivalRepository hopArrivalRepository;
    private HopRepository hopRepository;
    private FutureHopsRepository futureHopsRepository;
    private VisitedHopsRepository visitedHopsRepository;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopArrivalRepository hopArrivalRepository, HopRepository hopRepository, FutureHopsRepository futureHopsRepository, VisitedHopsRepository visitedHopsRepository) {
        this.parcelRepository = parcelRepository;
        this.recipientRepository = recipientRepository;
        this.hopArrivalRepository = hopArrivalRepository;
        this.hopRepository = hopRepository;
        this.futureHopsRepository = futureHopsRepository;
        this.visitedHopsRepository = visitedHopsRepository;
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

    @Override
    public NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws ValidationException, HttpClientErrorException{
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        validateParcel(parcel);

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation);
    }


    @Override
    public void reportParcelDelivery(String trackingId) throws ValidationException, HttpClientErrorException {

        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        ParcelEntity entity= getParcel(trackingId);

        entity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(entity);

    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws ValidationException, HttpClientErrorException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        ParcelEntity entity= getParcel(trackingId);

        return ParcelMapper.INSTANCE.trackingInformationFromEntity(entity);
    }



    @Override
    @Transactional
    public void reportParcelHop(String trackingId, String code) throws HttpClientErrorException{
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(newParcelInfo);

        ParcelEntity parcelEntity= getParcel(trackingId);

        String hopType= getHopType(code);

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

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) throws HttpClientErrorException{

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipient(parcel.getRecipient()));
        entity.setSender(getRecipient(parcel.getSender()));


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

    private ParcelEntity getParcel(String trackingId) throws HttpClientErrorException{
        ParcelEntity parcelEntity;
        try{
            parcelEntity= parcelRepository.findByTrackingId(trackingId).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return parcelEntity;
    }
    private RecipientEntity getRecipient(Recipient recipient){
        RecipientEntity recipientEntity= findRecipient(recipient);
        if(recipientEntity==null){
            recipientEntity= recipientRepository.save(RecipientMapper.INSTANCE.fromDTO(recipient));
        }
        return recipientEntity;
    }

    protected String getHopType(String code) throws HttpClientErrorException{
        if(doesHopExist(code)){
            try {
                Optional<String> hopType= hopRepository.getHoptypeByCode(code);
                if(hopType.isPresent()){
                    return hopType.get();
                }
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);

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
