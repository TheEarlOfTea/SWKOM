package io.swagger.businessLayer.connector.impl;
import io.swagger.businessLayer.connector.ParcelAPIConnector;
import io.swagger.businessLayer.validation.CodeValidator;
import io.swagger.businessLayer.validation.FullParcelValidator;
import io.swagger.businessLayer.validation.NewParcelInfoValidator;
import io.swagger.businessLayer.validation.ParcelValidator;
import io.swagger.mapper.CodeMapper;
import io.swagger.mapper.NewParcelInfoMapper;
import io.swagger.mapper.FullParcelMapper;
import io.swagger.mapper.ParcelMapper;
import io.swagger.persistence.entity.CodeEntity;
import io.swagger.persistence.entity.FullParcelEntity;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;
import lombok.extern.log4j.Log4j2;


//TODO: Configuration for own warehouse code and factories for NewParcelInfo, TrackingInfo
@Log4j2
public class ParcelConnector implements ParcelAPIConnector {

    public boolean submitParcel(Parcel parcel) {
        ParcelEntity parcelEntity= ParcelMapper.INSTANCE.from(parcel);
        if(!ParcelValidator.validateParcel(parcelEntity)){
            log.error("bad parcel");
            return false;
        }
        FullParcelEntity entity= FullParcelMapper.INSTANCE.from(NewParcelInfoMapper.INSTANCE.from(new NewParcelInfo().trackingId("123456789")), parcelEntity, new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED));
        if(!FullParcelValidator.validateFullParcel(entity)){
            log.error("bad fullparcel");
            return false;
        }
        System.out.println("Added new Parcel: " + entity.toString());
        return true;
    }

    public boolean trackParcel(String trackingId) {

        NewParcelInfoEntity trackingEntity= NewParcelInfoMapper.INSTANCE.from(trackingId);

        //trackparcel function
        if(!NewParcelInfoValidator.vaildateNewParcelInfo(trackingEntity)){
            log.error("bad trackingId " + trackingId);
            return false;
        }
        System.out.println("Tracking parcel with id \'" + trackingEntity.getTrackingId() + "\'");
        return true;
    }

    public boolean submitTransitionParcel(String trackingId, Parcel parcel) {
        NewParcelInfoEntity info= NewParcelInfoMapper.INSTANCE.from(trackingId);
        if(!NewParcelInfoValidator.vaildateNewParcelInfo(info)){
            log.error("bad trackingId");
            return false;
        }
        ParcelEntity parcelEntity= ParcelMapper.INSTANCE.from(parcel);
        if(!ParcelValidator.validateParcel(parcelEntity)){
            log.error("bad parcel");
            return false;
        }
        FullParcelEntity entity= FullParcelMapper.INSTANCE.from(info, parcelEntity,  new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED));
        if(!FullParcelValidator.validateFullParcel(entity)){
            log.error("bad full parcel");
            return false;
        }
        System.out.println("Added new Transition-Parcel: " + entity.toString());
        return true;
    }

    public boolean reportParcelDelivery(String trackingId) {

        NewParcelInfoEntity infoEntity= NewParcelInfoMapper.INSTANCE.from(trackingId);
        if(!NewParcelInfoValidator.vaildateNewParcelInfo(infoEntity)) {
            //reportParcelDelivery
            return false;
        }
        System.out.println("Parcel was delivered to this warehouse. Id: \'" + infoEntity.getTrackingId() + "\'");
        return true;
    }

    public boolean reportParcelHop(String trackingId, String code) {

        NewParcelInfoEntity infoEntity= NewParcelInfoMapper.INSTANCE.from(trackingId);
        if(!NewParcelInfoValidator.vaildateNewParcelInfo(infoEntity)){
            return false;
        }
        CodeEntity codeEntity= CodeMapper.INSTANCE.from(code);
        if(!CodeValidator.vaildateNewParcelInfo(codeEntity)){
            return false;
        }
        //reportParcelDelivery
        System.out.println("Parcel was delivered to this warehouse. Id: \'" + infoEntity.getTrackingId()+ "\'");
        return true;
    }
}
