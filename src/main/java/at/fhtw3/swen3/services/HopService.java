package at.fhtw3.swen3.services;

import at.fhtw3.swen3.services.dto.Hop;
import at.fhtw3.swen3.services.dto.Warehouse;

public interface HopService {

        Hop getWarehouse(String code);
        void importWarehouse(Warehouse warehouse);


}
