package at.fhtw.swen3.services;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HierachyNotLoadedException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.NotFoundExceptions.HopNotFoundException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadWareHouseDataException;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;

public interface WarehouseService {

        Hop getWarehouse(String code) throws HopNotFoundException;
        void importWarehouse(Warehouse warehouse) throws BadWareHouseDataException;
        Warehouse exportWarehouses() throws HierachyNotLoadedException;


}
