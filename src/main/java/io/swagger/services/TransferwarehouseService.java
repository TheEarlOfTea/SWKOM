package io.swagger.services;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Transferwarehouse;

import java.util.List;

public interface TransferwarehouseService {
    // Save operation
    TransferwarehouseEntity saveTransferwarehouseEntity(Transferwarehouse transferwarehouse);

    // Read operation
    List<Transferwarehouse> fetchTransferwarehouseEntityList();

    //getAll
    void getAllTransferwarehouseEntity(Transferwarehouse transferwarehouse);

    //getAll
    void findTransferwarehouseEntityByIdAll(Long transferwarehouseId);

    // Delete operation
    void deleteTransferwarehouseEntityById(Long transferwarehouseId);
}
