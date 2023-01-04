package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

import at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions.UserInputException;

public class BadCodeException extends UserInputException {
    public BadCodeException(String message) {
        super(message);
    }
}
