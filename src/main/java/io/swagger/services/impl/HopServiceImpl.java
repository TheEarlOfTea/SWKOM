package io.swagger.services.impl;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.persistence.repositories.WarehouseNextHopsRepository;
import io.swagger.services.HopService;
import io.swagger.services.dto.Hop;
import io.swagger.services.dto.Warehouse;
import io.swagger.services.mapper.HopMapper;
import io.swagger.services.mapper.WarehouseMapper;
import io.swagger.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class HopServiceImpl implements HopService {

    @Autowired
    private HopRepository hopRepository;
    @Autowired
    private WarehouseNextHopsRepository nextHopsRepository;


    @Override
    public Hop getWarehouse(String code) throws HttpClientErrorException{
        HopEntity entity;
        try{
            entity= hopRepository.findByCode(code).get(0);
        }catch (IndexOutOfBoundsException e){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        
        return HopMapper.INSTANCE.fromEntity(entity);
    }

    @Override
    public void importWarehouse(Warehouse warehouse) throws ValidationException, HttpClientErrorException {

    }
}
