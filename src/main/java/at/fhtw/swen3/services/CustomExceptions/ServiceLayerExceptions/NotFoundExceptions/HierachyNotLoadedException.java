package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;

public class HierachyNotLoadedException extends Exception{
    public HierachyNotLoadedException(String message) {
        super(message);
    }
}
