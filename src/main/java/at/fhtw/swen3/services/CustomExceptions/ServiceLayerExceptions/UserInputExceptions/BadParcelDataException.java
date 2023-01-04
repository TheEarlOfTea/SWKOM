package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

import at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions.UserInputException;

public class BadParcelDataException extends UserInputException {
    public BadParcelDataException(String message){
        super(message);
    }
}
