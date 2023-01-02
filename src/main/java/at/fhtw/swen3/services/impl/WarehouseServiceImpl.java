package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {


    private HopRepository hopRepository;
    private WarehouseNextHopsRepository nextHopsRepository;
    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(HopRepository hopRepository, WarehouseNextHopsRepository nextHopsRepository, WarehouseRepository warehouseRepository) {
        this.hopRepository = hopRepository;
        this.nextHopsRepository = nextHopsRepository;
        this.warehouseRepository= warehouseRepository;
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public Warehouse exportWarehouses() {
        List<WarehouseEntity> entityList= warehouseRepository.findByLevel(0);
        Warehouse warehouse= WarehouseMapper.INSTANCE.fromEntity(entityList.get(0));
        return warehouse;
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
