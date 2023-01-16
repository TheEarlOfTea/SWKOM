package at.fhtw.swen3.services;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.GPSProxyException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.ParcelNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.*;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public interface ParcelService {

    NewParcelInfo saveDomesticParcel(Parcel parcel) throws BadParcelDataException, BadAddressException, DuplicateTrackingIdException, HopNotFoundException, GPSProxyException;
    void reportParcelDelivery(String trackingId) throws BadTrackingIdException, ParcelNotFoundException, FutureHopsIsNotEmptyException;
    TrackingInformation trackParcel(String trackingId) throws BadTrackingIdException, ParcelNotFoundException;
    NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws BadParcelDataException, BadTrackingIdException, BadAddressException, DuplicateTrackingIdException, HopNotFoundException, GPSProxyException;
    void reportParcelHop(String trackingId, String code) throws BadTrackingIdException, ParcelNotFoundException, HopNotFoundException;
}
