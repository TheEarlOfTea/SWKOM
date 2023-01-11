package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;


public class HopNotFoundException  extends RuntimeException {
    public HopNotFoundException(String message) {
        super(message);
    }
}
