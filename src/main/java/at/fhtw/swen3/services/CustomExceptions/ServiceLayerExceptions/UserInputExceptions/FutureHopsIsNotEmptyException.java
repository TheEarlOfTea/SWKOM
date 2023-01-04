package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

public class FutureHopsIsNotEmptyException extends Exception{
    public FutureHopsIsNotEmptyException(String message) {
        super(message);
    }
}
