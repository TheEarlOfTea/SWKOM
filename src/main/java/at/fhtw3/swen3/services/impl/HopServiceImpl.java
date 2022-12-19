package at.fhtw3.swen3.services.impl;

import at.fhtw3.swen3.persistence.entities.HopEntity;
import at.fhtw3.swen3.persistence.repositories.HopRepository;
import at.fhtw3.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw3.swen3.services.HopService;
import at.fhtw3.swen3.services.dto.Hop;
import at.fhtw3.swen3.services.dto.Warehouse;
import at.fhtw3.swen3.services.mapper.HopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;

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
