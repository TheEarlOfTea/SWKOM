package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.factories.NewParcelInfoFactory;
import at.fhtw.swen3.factories.TrackingInformationFactory;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.repositories.HopArrivalRepository;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.ParcelNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.PredictService;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {


    private final ParcelRepository parcelRepository;
    private final RecipientRepository recipientRepository;
    private final HopArrivalRepository hopArrivalRepository;
    private final HopRepository hopRepository;
    private final PredictService predictService;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopArrivalRepository hopArrivalRepository, HopRepository hopRepository, PredictService predictService) {
        this.parcelRepository = parcelRepository;
        this.recipientRepository = recipientRepository;
        this.hopArrivalRepository = hopArrivalRepository;
        this.hopRepository = hopRepository;
        this.predictService = predictService;
    }

    @SneakyThrows
    @Override
    public NewParcelInfo saveDomesticParcel(Parcel parcel) {

        //throws BadParcelDataException
        validateParcel(parcel);

        List<HopArrival> predict = predictService.predict(parcel);
        NewParcelInfo newParcelInfo= NewParcelInfoFactory.getNewParcelInfo();

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation, predict);

    }

    @Override
    public NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws BadParcelDataException, BadTrackingIdException, BadAddressException, DuplicateTrackingIdException {
        //throws BadTrackingIdException
        validateTrackingId(trackingId);
        //throws BadParcelDataException
        validateParcel(parcel);

        List<HopArrival> predict = predictService.predict(parcel);
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);

        TrackingInformation trackingInformation= TrackingInformationFactory.getTrackingInformation();

        return saveParcel(newParcelInfo, parcel, trackingInformation, predict);

    }


    @Override
    public void reportParcelDelivery(String trackingId) throws BadTrackingIdException, ParcelNotFoundException, FutureHopsIsNotEmptyException {

        //throws BadTrackingIdException
        validateTrackingId(trackingId);

        //throws ParcelNotFoundException
        ParcelEntity entity=getParcel(trackingId);
//        if(!entity.getFutureHops().isEmpty()){
//            throw new FutureHopsIsNotEmptyException("Parcel cannot be delivered before it hasn't passed all future hops");
//        }
        entity.setFutureHops(new ArrayList<>());

        entity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(entity);

    }

    @Override
    public TrackingInformation trackParcel(String trackingId) throws BadTrackingIdException, ParcelNotFoundException {
        //throws BadTrackingIdException
        validateTrackingId(trackingId);

        //throws ParcelNotFoundException
        ParcelEntity entity= getParcel(trackingId);

        return ParcelMapper.INSTANCE.trackingInformationFromEntity(entity);
    }





    @Override
    @Transactional
    public void reportParcelHop(String trackingId, String code) throws BadTrackingIdException, ParcelNotFoundException, HopNotFoundException {
        //throws BadTrackingIdException
        validateTrackingId(trackingId);

        //throws ParcelNotFoundException
        ParcelEntity parcelEntity= getParcel(trackingId);

        //throws HopNotFoundException
        String hopType= getHopType(code);

        //todo: testen
        if(!Objects.equals(parcelEntity.getFutureHops().get(0).getCode(), code)){
            throw new HopNotFoundException("Hop with given code is not the next hop of the parcel");
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

    public void validateTrackingId(String trackingId) throws BadTrackingIdException {
        NewParcelInfo newParcelInfo= new NewParcelInfo().trackingId(trackingId);
        try{
            Validator.validate(newParcelInfo);
        }catch (ValidationException e){
            log.error("Tracking-Id failed validation. " + e.getMessage());
            throw new BadTrackingIdException("Tracking-Id received does not conform with our UUID standards. Nested Exception: " + e.getMessage());
        }
    }

    public void validateParcel(Parcel parcel) throws BadParcelDataException {
        try{
            Validator.validate(parcel);
        }catch (ValidationException e){
            log.error("Parcel failed validation. " + e.getMessage());
            throw new BadParcelDataException("Parcel received failed validation. Nested Exception: " + e.getMessage());
        }
    }

    private NewParcelInfo saveParcel(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation, List<HopArrival> predict) throws DuplicateTrackingIdException {

        Optional<String> trackingId= parcelRepository.doesTrackingIdExist(newParcelInfo.getTrackingId());
        if(trackingId.isPresent()){
            log.error("Tracking-Id " + newParcelInfo.getTrackingId() + " already exists in Database");
            throw new DuplicateTrackingIdException("Tracking-Id already exists");
        }

        ParcelEntity entity= ParcelMapper.INSTANCE.fromDTO(newParcelInfo, parcel, trackingInformation);

        entity.setRecipient(getRecipient(parcel.getRecipient()));
        entity.setSender(getRecipient(parcel.getSender()));
        entity.setFutureHops(predict.stream().map(HopArrivalMapper.INSTANCE::fromDTO).collect(Collectors.toList()));

        //save hopArrivals
        hopArrivalRepository.saveAll(entity.getVisitedHops());
        hopArrivalRepository.saveAll(entity.getFutureHops());

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
            log.error("Invalid Tracking-Id given by user. Parcel with given TrackingId " + trackingId + " could not be found");
            throw new ParcelNotFoundException("Parcel with given trackingId " + trackingId + " does not exist");
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

    protected String getHopType(String code) throws HopNotFoundException {
        if(doesHopExist(code)){
            return hopRepository.getHoptypeByCode(code).get();
        }
        log.error("User gave non-existing code of a hop as input. Code: " + code);
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
