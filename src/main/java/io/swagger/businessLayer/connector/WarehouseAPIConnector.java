package io.swagger.businessLayer.connector;

import io.swagger.model.Warehouse;

import java.util.List;

public interface WarehouseAPIConnector {
    public Warehouse getWarehouse(String code);
    public boolean importWarehouse(Warehouse warehouse);
}
