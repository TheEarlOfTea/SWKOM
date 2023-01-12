package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.TransferwarehouseMapper;
import at.fhtw.swen3.services.mapper.TruckMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopRepositoryTest {

    @Autowired
    HopRepository hopRepository;

    public Hop hop;
    public Warehouse warehouse;
    public Truck truck;
    public Transferwarehouse transferwarehouse;

    LinkedList<WarehouseNextHops> list;

    @BeforeEach
    void init(){

        hop= new Hop();
        hop.setDummyData();
        warehouse= new Warehouse().level(1);
        warehouse.setCode("WAREHOUSE");
        warehouse.setDummyData();
        truck= new Truck();
        truck.setDummyData();
        truck.setCode("TRUCK");
        truck.setNumberPlate("abc");
        truck.setRegionGeoJson("abc");
        transferwarehouse= new Transferwarehouse();
        transferwarehouse.setDummyData();
        transferwarehouse.setCode("TRANSFERWAREHOUSE");
        transferwarehouse.setRegionGeoJson("abc");
        transferwarehouse.setLogisticsPartner("abc");
        transferwarehouse.setLogisticsPartnerUrl("abc");
    }

    @Test
    public void testDB() {


        HopEntity hopEntity= hopRepository.save(HopMapper.INSTANCE.fromDTO(hop));
        WarehouseEntity warehouseEntity= hopRepository.save(WarehouseMapper.INSTANCE.fromDTO(warehouse));
        TruckEntity truckEntity= hopRepository.save(TruckMapper.INSTANCE.fromDTO(truck));
        TransferwarehouseEntity transferWarehouseEntity= hopRepository.save(TransferwarehouseMapper.INSTANCE.fromDTO(transferwarehouse));

        Optional<HopEntity> optionalHopEntity= hopRepository.findById(hopEntity.getId());
        Optional<HopEntity> optionalWarehouseEntity= hopRepository.findById(warehouseEntity.getId());
        Optional<HopEntity> optionalTruckEntity= hopRepository.findById(truckEntity.getId());
        Optional<HopEntity> optionalTransferWarehouseEntity= hopRepository.findById(transferWarehouseEntity.getId());


        assert(optionalHopEntity.isPresent());
        assert(optionalWarehouseEntity.isPresent());
        assert(optionalTruckEntity.isPresent());
        assert(optionalTransferWarehouseEntity.isPresent());

        hopRepository.delete(hopEntity);
        hopRepository.delete(warehouseEntity);
        hopRepository.delete(truckEntity);
        hopRepository.delete(transferWarehouseEntity);
    }

}