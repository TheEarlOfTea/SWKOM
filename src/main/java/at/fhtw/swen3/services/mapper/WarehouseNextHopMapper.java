package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    @Named("hopToHopEntity")
    public static HopEntity hopToHopEntity(Hop hop){
        return HopMapper.INSTANCE.fromDTO(hop);
    }
    @Named("hopEntityToHop")
    public static Hop hopEntityToHop(HopEntity entity){
        return HopMapper.INSTANCE.fromEntity(entity);
    }

    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopToHopEntity")
    WarehouseNextHopsEntity fromDTO(WarehouseNextHops warehouseNextHops);
    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopEntityToHop")
    WarehouseNextHops fromEntity(WarehouseNextHopsEntity entity);
}
