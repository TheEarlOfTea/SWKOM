package io.swagger.businessLayer.connector.impl;
import io.swagger.businessLayer.connector.ParcelAPIConnector;
import io.swagger.businessLayer.validation.ParcelValidator;
import io.swagger.mapper.ParcelMapper;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import io.swagger.services.dto.TrackingInformation;


//TODO: Configuration for own warehouse code and factories for NewParcelInfo, TrackingInfo

public class ParcelConnector implements ParcelAPIConnector {

    public boolean submitParcel(Parcel parcel) {
        ParcelEntity entity= ParcelMapper.INSTANCE.from(new NewParcelInfo(), parcel, new TrackingInformation());
        ParcelValidator.validateParcel(entity);
        System.out.println("Added new Parcel: " + entity.toString());
        return true;

    }

    public boolean trackParcel(String trackingId) {
        //trackparcel function
        //validate
        System.out.println("Tracking parcel with id \'" + trackingId + "\'");
        return true;

    }

    public boolean submitTransitionParcel(Parcel parcel) {
        ParcelEntity entity= ParcelMapper.INSTANCE.from(new NewParcelInfo(), parcel, new TrackingInformation());
        ParcelValidator.validateParcel(entity);
        System.out.println("Added new Transition-Parcel: " + entity.toString());
        return true;
    }

    public boolean reportParcelDelivery(String trackingId) {

        //validate trackingId
        //reportParcelDelivery
        System.out.println("Parcel was delivered to this warehouse. Id: \'" + trackingId+ "\'");
        return true;
    }

    public boolean reportParcelHop(String trackingId, String code) {
        //validate trackingId
        //validate code
        //reportParcelDelivery
        System.out.println("Parcel was delivered to this warehouse. Id: \'" + trackingId+ "\'");
        return true;
    }
}
