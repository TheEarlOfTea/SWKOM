package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;
public class BadAddressException extends Exception{
    public BadAddressException(String message) {
        super(message);
    }
}
