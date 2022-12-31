package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;

public interface WarehouseService {

        Hop getWarehouse(String code);
        void importWarehouse(Warehouse warehouse);


}
