package io.swagger.services;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Recipient;
import io.swagger.services.dto.Transferwarehouse;

import java.util.List;

public interface TransferwarehouseService {
    void save(Transferwarehouse transferwarehouse);
    List<Transferwarehouse> findAll();
    void deleteById(long id);
    Transferwarehouse getById(long id);
}
