package at.fhtw3.swen3.services;

public class WarehouseNotFoundException extends RuntimeException {
    public WarehouseNotFoundException(String msg) {
        super(msg);
    }
}
