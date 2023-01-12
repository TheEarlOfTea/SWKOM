package at.fhtw.swen3.services;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;

public interface PredictionService {

    TrackingInformation getTrackingInformation(Recipient recipient, Recipient sender) throws BadAddressException;
}
