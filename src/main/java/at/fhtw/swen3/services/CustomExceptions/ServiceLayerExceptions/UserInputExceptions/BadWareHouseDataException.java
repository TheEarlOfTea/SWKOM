package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions;

public class BadWareHouseDataException extends Exception{
    public BadWareHouseDataException(String message) {
        super(message);
    }
}
