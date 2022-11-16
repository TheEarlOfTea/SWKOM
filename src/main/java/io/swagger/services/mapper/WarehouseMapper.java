package io.swagger.services.mapper;

import io.swagger.persistence.entities.WarehouseEntity;
import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import io.swagger.services.dto.Warehouse;
import io.swagger.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface WarehouseMapper extends CoordinateToPointMapper{
    WarehouseMapper INSTANCE= Mappers.getMapper(WarehouseMapper.class);

    @Named("nextHopsDtoToEntity")
    public static List<WarehouseNextHopsEntity> nextHopsDtoToEntity(List<WarehouseNextHops> list){
        LinkedList<WarehouseNextHopsEntity> newList= new LinkedList<WarehouseNextHopsEntity>();
        for(WarehouseNextHops i : list){
            newList.add(WarehouseNextHopMapper.INSTANCE.fromDTO(i));
        }
        return newList;
    }

    @Named("nextHopsEntityToDto")
    public static List<WarehouseNextHops> nextHopsEntityToDto(List<WarehouseNextHopsEntity> list){
        LinkedList<WarehouseNextHops> newList= new LinkedList<WarehouseNextHops>();
        for(WarehouseNextHopsEntity i : list){
            newList.add(WarehouseNextHopMapper.INSTANCE.fromEntity(i));
        }
        return newList;
    }
    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    @Mapping(source = "nextHops", target = "nextHops", qualifiedByName = "nextHopsDtoToEntity")
    WarehouseEntity fromDTO(Warehouse warehouse);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    @Mapping(source = "nextHops", target = "nextHops", qualifiedByName = "nextHopsEntityToDto")
    Warehouse fromEntity(WarehouseEntity entity);
}
