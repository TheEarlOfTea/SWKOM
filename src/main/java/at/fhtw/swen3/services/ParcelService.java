package at.fhtw.swen3.services;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.ParcelNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.*;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

public interface ParcelService {

    NewParcelInfo saveDomesticParcel(Parcel parcel) throws BadParcelDataException, BadAddressException, DuplicateTrackingIdException, HopNotFoundException;
    void reportParcelDelivery(String trackingId) throws BadTrackingIdException, ParcelNotFoundException, FutureHopsIsNotEmptyException;
    TrackingInformation trackParcel(String trackingId) throws BadTrackingIdException, ParcelNotFoundException;
    NewParcelInfo saveTransitionParcel(String trackingId, Parcel parcel) throws BadParcelDataException, BadTrackingIdException, BadAddressException, DuplicateTrackingIdException, HopNotFoundException;
    void reportParcelHop(String trackingId, String code) throws BadTrackingIdException, ParcelNotFoundException, HopNotFoundException;
}
