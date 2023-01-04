package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;

import at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions.NotFoundException;

public class HopNotFoundException  extends NotFoundException {
    public HopNotFoundException(String message) {
        super(message);
    }
}
