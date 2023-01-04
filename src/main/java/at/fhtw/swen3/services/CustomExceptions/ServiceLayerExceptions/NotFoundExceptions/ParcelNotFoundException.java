package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;

public class ParcelNotFoundException extends Exception {
    public ParcelNotFoundException(String message) {
        super(message);
    }
}
