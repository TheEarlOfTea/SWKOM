package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

public class BadTrackingIdException extends Exception {
    public BadTrackingIdException(String message) {
        super(message);
    }
}
