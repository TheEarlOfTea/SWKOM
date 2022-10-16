package io.swagger.businessLayer.connector.impl;

import io.swagger.businessLayer.connector.WarehouseAPIConnector;
import io.swagger.businessLayer.validation.CodeValidator;
import io.swagger.businessLayer.validation.WarehouseValidator;
import io.swagger.mapper.CodeMapper;
import io.swagger.mapper.WarehouseMapper;
import io.swagger.persistence.entity.WarehouseEntity;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;
import io.swagger.persistence.entity.CodeEntity;

import javax.validation.ValidationException;

public class WarehouseConnector implements WarehouseAPIConnector {

    @Override
    public Hop getWarehouse(String code) throws ValidationException {

        CodeEntity codeEntity= CodeMapper.INSTANCE.from(code);
        if(!CodeValidator.vaildateNewParcelInfo(codeEntity)){
            throw new ValidationException("code validation failed, bad code");
        }
        Hop hop= new Hop();
        //get hop
        hop.setCode(code);
        return hop;
    }

    @Override
    public boolean importWarehouse(Warehouse warehouse) {

        WarehouseEntity entity= WarehouseMapper.INSTANCE.from(warehouse);
        if(WarehouseValidator.validateWarehouse(entity)){
            //import warehouse
            System.out.println("added new warehouse");
            return true;
        }
        return false;

    }
}
