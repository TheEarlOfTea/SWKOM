package io.swagger.services;

import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;

import java.util.List;

public interface HopService {

        Hop getWarehouse(String code);
        void importWarehouse(Warehouse warehouse);


}
