package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;


public class BadParcelDataException extends Exception {
    public BadParcelDataException(String message){
        super(message);
    }
}
