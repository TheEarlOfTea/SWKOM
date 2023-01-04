package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

import at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions.UserInputException;

public class BadTrackingIdException extends UserInputException {
    public BadTrackingIdException(String message) {
        super(message);
    }
}
