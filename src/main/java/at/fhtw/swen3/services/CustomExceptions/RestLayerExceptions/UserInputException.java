package at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions;

public abstract class UserInputException extends Exception{
    public UserInputException(String message) {
        super(message);
    }
}
