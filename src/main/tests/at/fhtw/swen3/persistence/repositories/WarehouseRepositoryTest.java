package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseRepositoryTest {
    @Autowired
    WarehouseRepository repository;

    public Warehouse warehouse;

    @BeforeEach
    void init() {
        warehouse= new Warehouse().level(1);
        warehouse.setCode("WAREHOUSE");
        warehouse.setDummyData();
    }

    @Test
    public void testDB() {

        WarehouseEntity warehouseEntity= repository.save(WarehouseMapper.INSTANCE.fromDTO(warehouse));

        Optional<WarehouseEntity> optionalWarehouseEntity= repository.findById(warehouseEntity.getId());

        assert(optionalWarehouseEntity.isPresent());

        repository.delete(warehouseEntity);
    }
}