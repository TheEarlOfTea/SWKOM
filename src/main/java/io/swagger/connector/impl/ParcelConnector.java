package io.swagger.connector.impl;

import io.swagger.businessLayer.validation.Validator;
import io.swagger.connector.ParcelAPIConnector;
import io.swagger.dataAccessLayer.JDBC.DatabaseConnector;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.NewParcelInfo;
import io.swagger.services.dto.Parcel;
import lombok.extern.log4j.Log4j2;

import javax.validation.ValidationException;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
public class ParcelConnector implements ParcelAPIConnector {

    public void submitParcel(Parcel parcel) throws ValidationException {
        Validator.validate(parcel);
        //parcel entity code
        System.out.println("Added new Parcel: " + parcel.toString());
    }

    public void trackParcel(String trackingId) throws ValidationException{

        NewParcelInfo info= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(info);
        //trackparcel function

        System.out.println("Tracking parcel with id \'" + info.getTrackingId() + "\'");
    }

    public void submitTransitionParcel(String trackingId, Parcel parcel) throws ValidationException{
        NewParcelInfo info= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(info);
        Validator.validate(parcel);
        //submitTransitionParcel function
        System.out.println("Added new Transitionparcel with id: " + info.getTrackingId());
    }

    public void reportParcelDelivery(String trackingId) throws ValidationException{

        NewParcelInfo info= new NewParcelInfo().trackingId(trackingId);
        Validator.validate(info);
        //trackparcel function

        System.out.println("Tracking parcel with id \'" + info.getTrackingId() + "\'");
    }

    public void reportParcelHop(String trackingId, String code) throws ValidationException{

        NewParcelInfo info= new NewParcelInfo().trackingId(trackingId);
        Hop hop= new Hop();
        hop.setDummyData();
        hop.setCode(code);
        Validator.validate(info);
        Validator.validate(hop);

        //report parcel function

        System.out.println("reported parcel hop with trackingId: " + info.getTrackingId());

    }
}
