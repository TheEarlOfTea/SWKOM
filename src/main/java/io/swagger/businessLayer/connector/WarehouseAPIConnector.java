package io.swagger.businessLayer.connector;

import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;

public interface WarehouseAPIConnector {
    public Hop getWarehouse(String code);
    public void importWarehouse(Warehouse warehouse);
}
