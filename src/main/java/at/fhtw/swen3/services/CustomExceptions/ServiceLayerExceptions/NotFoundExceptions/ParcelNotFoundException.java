package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;

import at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions.NotFoundException;

public class ParcelNotFoundException extends NotFoundException {
    public ParcelNotFoundException(String message) {
        super(message);
    }
}
