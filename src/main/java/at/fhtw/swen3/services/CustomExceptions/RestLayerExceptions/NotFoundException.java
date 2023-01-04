package at.fhtw.swen3.services.CustomExceptions.RestLayerExceptions;

public abstract class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
