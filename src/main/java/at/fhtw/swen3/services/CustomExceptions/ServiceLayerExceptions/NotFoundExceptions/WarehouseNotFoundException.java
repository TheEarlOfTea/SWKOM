package at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions;

public class WarehouseNotFoundException extends Exception{
    public WarehouseNotFoundException(String message) {
        super(message);
    }
}
