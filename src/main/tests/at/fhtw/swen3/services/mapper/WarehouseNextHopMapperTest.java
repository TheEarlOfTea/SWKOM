package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseNextHopMapperTest {

    Hop dummyHop;
    WarehouseNextHops nextHops;

    void setUp(){
        dummyHop= new Hop();
        dummyHop.setDummyData();
        nextHops= new WarehouseNextHops().hop(dummyHop).traveltimeMins(2);
    }

    @Test
    void fromDTO() {

        setUp();
        WarehouseNextHopsEntity entity= WarehouseNextHopMapper.INSTANCE.fromDTO(nextHops);

        assertEquals(nextHops.getHop(), HopMapper.INSTANCE.fromEntity(entity.getHop()));
        assertEquals(nextHops.getTraveltimeMins(), entity.getTraveltimeMins());

    }

    @Test
    void fromEntity() {

        setUp();
        WarehouseNextHopsEntity entity= WarehouseNextHopMapper.INSTANCE.fromDTO(nextHops);
        WarehouseNextHops newNextHops= WarehouseNextHopMapper.INSTANCE.fromEntity(entity);

        assertEquals(entity.getHop(), HopMapper.INSTANCE.fromDTO(newNextHops.getHop()));
        assertEquals(entity.getTraveltimeMins(), newNextHops.getTraveltimeMins());
    }
}