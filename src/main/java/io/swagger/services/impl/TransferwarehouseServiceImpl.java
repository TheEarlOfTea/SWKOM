package io.swagger.services.impl;


import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.persistence.repositories.TransferwarehouseRepository;
import io.swagger.services.TransferwarehouseService;
import io.swagger.services.dto.Transferwarehouse;
import io.swagger.services.mapper.TransferwarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service

public class TransferwarehouseServiceImpl implements TransferwarehouseService {
    @Autowired
    private TransferwarehouseRepository transferwarehouseRepository;
    @Autowired
    private TransferwarehouseMapper transferwarehouseMapper;

    // Save operation
    @Override
    public TransferwarehouseEntity saveTransferwarehouseEntity(Transferwarehouse transferwarehouse) {
        return transferwarehouseRepository.save(transferwarehouseMapper.fromDTO(transferwarehouse));
    }


    // Read operation
    @Override public List<Transferwarehouse> fetchTransferwarehouseEntityList() {
        List<Transferwarehouse> transferwarehouses = new LinkedList<>();
        for (TransferwarehouseEntity transferwarehouseEntity:transferwarehouseRepository.findAll()) {
            transferwarehouses.add(transferwarehouseMapper.fromEntity(transferwarehouseEntity));
        }
        return transferwarehouses;
    }

    @Override
    public void getAllTransferwarehouseEntity(Transferwarehouse transferwarehouse) {

    }

    @Override
    public void findTransferwarehouseEntityByIdAll(Long transferwarehouseId) {

    }


    // Delete operation
    @Override
    public void deleteTransferwarehouseEntityById(Long Id){
        transferwarehouseRepository.deleteById(Id);
    }




}
