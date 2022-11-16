package io.swagger.services.mapper;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import io.swagger.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferwarehouseMapperTest {

    Transferwarehouse transferwarehouse= new Transferwarehouse().logisticsPartner("logisticsPartner").logisticsPartnerUrl("logisticsPartnerUrl").regionGeoJson("regionGeoJson");

    @Test
    void fromDTO() {
        transferwarehouse.setDummyData();
        TransferwarehouseEntity entity= TransferwarehouseMapper.INSTANCE.fromDTO(transferwarehouse);
        assertEquals(transferwarehouse.getCode(), entity.getCode());
        assertEquals(transferwarehouse.getDescription(), entity.getDescription());
        assertEquals(transferwarehouse.getHopType(), entity.getHopType());
        assertEquals(transferwarehouse.getLocationCoordinates().getLon(), entity.getLocationCoordinates().getLon());
        assertEquals(transferwarehouse.getLocationCoordinates().getLat(), entity.getLocationCoordinates().getLat());
        assertEquals(transferwarehouse.getLocationName(), entity.getLocationName());
        assertEquals(transferwarehouse.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), entity.getLogisticsPartnerUrl());
        assertEquals(transferwarehouse.getLogisticsPartner(), entity.getLogisticsPartner());
        assertEquals(transferwarehouse.getRegionGeoJson(), entity.getRegionGeoJson());
    }

    @Test
    void fromEntity() {
        transferwarehouse.setDummyData();
        TransferwarehouseEntity entity= TransferwarehouseMapper.INSTANCE.fromDTO(transferwarehouse);
        Transferwarehouse newWarehouse= TransferwarehouseMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getCode(), newWarehouse.getCode());
        assertEquals(entity.getDescription(), newWarehouse.getDescription());
        assertEquals(entity.getHopType(), newWarehouse.getHopType());
        assertEquals(entity.getLocationCoordinates().getLon(), newWarehouse.getLocationCoordinates().getLon());
        assertEquals(entity.getLocationCoordinates().getLat(), newWarehouse.getLocationCoordinates().getLat());
        assertEquals(entity.getLocationName(), newWarehouse.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newWarehouse.getProcessingDelayMins());
        assertEquals(entity.getLogisticsPartnerUrl(), newWarehouse.getLogisticsPartnerUrl());
        assertEquals(entity.getLogisticsPartner(), newWarehouse.getLogisticsPartner());
        assertEquals(entity.getRegionGeoJson(), newWarehouse.getRegionGeoJson());

    }
}