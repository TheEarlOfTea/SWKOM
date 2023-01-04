package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;


public class BadCodeException extends Exception{
    public BadCodeException(String message) {
        super(message);
    }
}
