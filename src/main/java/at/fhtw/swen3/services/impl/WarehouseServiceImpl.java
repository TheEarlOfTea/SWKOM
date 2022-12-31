package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.mapper.WarehouseNextHopMapper;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;

@Service
public class WarehouseServiceImpl implements WarehouseService {


    private HopRepository hopRepository;
    private WarehouseNextHopsRepository nextHopsRepository;

    @Autowired
    public WarehouseServiceImpl(HopRepository hopRepository, WarehouseNextHopsRepository nextHopsRepository) {
        this.hopRepository = hopRepository;
        this.nextHopsRepository = nextHopsRepository;
    }

    @Override
    public Hop getWarehouse(String code) throws HttpClientErrorException {
        HopEntity entity;
        try {
            entity = hopRepository.findByCode(code).get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return HopMapper.INSTANCE.fromEntity(entity);
    }

    @Override
    public void importWarehouse(Warehouse warehouse) throws ValidationException, HttpClientErrorException {
        Validator.validate(warehouse);
        nextHopsRepository.deleteAll();
        hopRepository.deleteAll();
        saveWarehouse(WarehouseMapper.INSTANCE.fromDTO(warehouse));
    }

    private HopEntity saveWarehouse(HopEntity hopEntity) {
        if(hopEntity.getClass()!=WarehouseEntity.class){
            return hopRepository.save(hopEntity);
        }
        else {
            WarehouseEntity entity=(WarehouseEntity)(hopEntity);
            for(WarehouseNextHopsEntity nextHopsEntity: entity.getNextHops()){
                nextHopsEntity.setHop(saveWarehouse(nextHopsEntity.getHop()));
                nextHopsRepository.save(nextHopsEntity);
            }
            return hopRepository.save(entity);
        }
    }
}
