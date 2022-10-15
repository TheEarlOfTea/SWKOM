package io.swagger.businessLayer.connector.impl;

import io.swagger.businessLayer.connector.WarehouseAPIConnector;
import io.swagger.model.Warehouse;

import java.util.LinkedList;
import java.util.List;

public class WarehouseConnector implements WarehouseAPIConnector {

    @Override
    public Warehouse getWarehouse(String code) {
        //validate code
        Warehouse warehouse= new Warehouse();
        warehouse.setCode(code);
        return warehouse;
    }

    @Override
    public boolean importWarehouse(Warehouse warehouse) {
        //validation
        //import warehouse function
        System.out.println("added new warehouse");
        return true;
    }
}
