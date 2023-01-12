package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.mapper.TruckMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.mapper.WarehouseNextHopMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseNextHopsRepositoryTest {
    @Autowired
    WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    HopRepository hopRepository;

    public Warehouse warehouse;
    public WarehouseNextHops warehouseNextHops;
    public Truck truck;

    @BeforeEach
    void init() {
        warehouse= new Warehouse().level(1);
        warehouse.setCode("WAREHOUSE");
        warehouse.setDummyData();
        warehouse.setNextHops(new ArrayList<WarehouseNextHops>());

        truck= new Truck();
        truck.setDummyData();
        truck.setCode("TRUCK");
        truck.setNumberPlate("abc");
        truck.setRegionGeoJson("abc");

        warehouseNextHops= new WarehouseNextHops();
        warehouseNextHops.setTraveltimeMins(12);
        warehouseNextHops.setHop(truck);
    }

    @Test
    public void testDB() {

        WarehouseEntity warehouseEntity= hopRepository.save(WarehouseMapper.INSTANCE.fromDTO(warehouse));
        TruckEntity truckEntity= hopRepository.save(TruckMapper.INSTANCE.fromDTO(truck));
        WarehouseNextHopsEntity warehouseNextHopsEntity= WarehouseNextHopMapper.INSTANCE.fromDTO(warehouseNextHops);

        warehouseNextHopsEntity.setWarehouse(warehouseEntity);
        warehouseNextHopsEntity.setHop(truckEntity);

        warehouseNextHopsEntity= warehouseNextHopsRepository.save(warehouseNextHopsEntity);

        Optional<WarehouseNextHopsEntity> optionalWarehouseNextHopsEntity= warehouseNextHopsRepository.findById(warehouseNextHopsEntity.getId());

        assert(optionalWarehouseNextHopsEntity.isPresent());

        warehouseNextHopsRepository.delete(warehouseNextHopsEntity);
        hopRepository.delete(truckEntity);
        hopRepository.delete(warehouseEntity);

    }
}