package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

public class DuplicateTrackingIdException extends Exception{
    public DuplicateTrackingIdException(String message) {
        super(message);
    }
}
