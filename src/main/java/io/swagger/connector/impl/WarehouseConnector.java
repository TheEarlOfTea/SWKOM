package io.swagger.connector.impl;

import io.swagger.businessLayer.validation.Validator;
import io.swagger.connector.WarehouseAPIConnector;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;

import javax.validation.ValidationException;

public class WarehouseConnector implements WarehouseAPIConnector {

    @Override
    public Hop getWarehouse(String code) throws ValidationException {

        Hop hop= new Hop();
        hop.setDummyData();
        hop.setCode(code);
        Validator.validate(hop);
        //get hop
        return hop;
    }

    @Override
    public void importWarehouse(Warehouse warehouse) {

        Validator.validate(warehouse);
        //import warehouse

        System.out.println("imported new warehouse: " + warehouse.toString());

    }
}
