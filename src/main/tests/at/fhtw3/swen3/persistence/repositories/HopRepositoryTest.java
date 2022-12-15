package at.fhtw3.swen3.persistence.repositories;

import at.fhtw3.swen3.persistence.entities.*;
import at.fhtw3.swen3.services.dto.*;
import at.fhtw3.swen3.services.mapper.HopMapper;
import at.fhtw3.swen3.services.mapper.TransferwarehouseMapper;
import at.fhtw3.swen3.services.mapper.TruckMapper;
import at.fhtw3.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HopRepositoryTest {

    @Autowired
    HopRepository hopRepository;
    @Autowired
    WarehouseNextHopsRepository warehouseNextHopsRepository;

    public Hop hop;
    public Hop nextHop;
    public Warehouse warehouse;
    public Truck truck;
    public Transferwarehouse transferwarehouse;

    LinkedList<WarehouseNextHops> list;

    @BeforeEach
    void init(){
        warehouseNextHopsRepository.deleteAll();
        hopRepository.deleteAll();

        hop= new Hop();
        hop.setDummyData();
        nextHop= new Hop();
        nextHop.setDummyData();
        nextHop.setLocationName("NEXTHOP");
        warehouse= new Warehouse().level(1);
        warehouse.setDummyData();
        list= new LinkedList<WarehouseNextHops>();
        list.add(new WarehouseNextHops().hop(nextHop).traveltimeMins(2));
        warehouse.setNextHops(list);
        truck= new Truck();
        truck.setDummyData();
        truck.setNumberPlate("abc");
        truck.setRegionGeoJson("abc");
        transferwarehouse= new Transferwarehouse();
        transferwarehouse.setDummyData();
        transferwarehouse.setRegionGeoJson("abc");
        transferwarehouse.setLogisticsPartner("abc");
        transferwarehouse.setLogisticsPartnerUrl("abc");
    }

    @Test
    public void testSave() {

        HopEntity hopEntity= HopMapper.INSTANCE.fromDTO(hop);
        WarehouseEntity warehouseEntity= WarehouseMapper.INSTANCE.fromDTO(warehouse);
        TruckEntity truckEntity= TruckMapper.INSTANCE.fromDTO(truck);
        TransferwarehouseEntity transferwarehouseEntity= TransferwarehouseMapper.INSTANCE.fromDTO(transferwarehouse);
        HopEntity nextHopEntity= warehouseEntity.getNextHops().get(0).getHop();

        hopRepository.save(hopEntity);
        hopRepository.save(nextHopEntity);
        hopRepository.save(truckEntity);
        hopRepository.save(transferwarehouseEntity);

        for(WarehouseNextHopsEntity e : warehouseEntity.getNextHops()){
            warehouseNextHopsRepository.save(e);
        }
        hopRepository.save(warehouseEntity);

        assertEquals(5, hopRepository.count());
        assertEquals(1, warehouseNextHopsRepository.count());



    }

}