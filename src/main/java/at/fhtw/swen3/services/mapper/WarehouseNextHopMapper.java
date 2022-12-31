package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WarehouseNextHopMapper {
    WarehouseNextHopMapper INSTANCE= Mappers.getMapper(WarehouseNextHopMapper.class);

    @Named("hopToHopEntity")
    public static HopEntity hopToHopEntity(Hop hop){
        if(hop.getClass()==Hop.class){
            return HopMapper.INSTANCE.fromDTO(hop);
        }
        if(hop.getClass()== Truck.class){
            return TruckMapper.INSTANCE.fromDTO((Truck)(hop));
        }
        if(hop.getClass()== Warehouse.class){
            return WarehouseMapper.INSTANCE.fromDTO((Warehouse)(hop));
        }
        if(hop.getClass()== Transferwarehouse.class){
            return TransferwarehouseMapper.INSTANCE.fromDTO((Transferwarehouse)(hop));
        }

        return null;
    }
    @Named("hopEntityToHop")
    public static Hop hopEntityToHop(HopEntity entity){
        if(entity.getClass()==HopEntity.class){
            return HopMapper.INSTANCE.fromEntity(entity);
        }
        if(entity.getClass()== TruckEntity.class){
            return TruckMapper.INSTANCE.fromEntity((TruckEntity)(entity));
        }
        if(entity.getClass()== WarehouseEntity.class){
            return WarehouseMapper.INSTANCE.fromEntity((WarehouseEntity)(entity));
        }
        if(entity.getClass()== TransferwarehouseEntity.class){
            return TransferwarehouseMapper.INSTANCE.fromEntity((TransferwarehouseEntity)(entity));
        }
        return null;
    }

    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopToHopEntity")
    WarehouseNextHopsEntity fromDTO(WarehouseNextHops warehouseNextHops);
    @Mapping(source = "hop", target = "hop", qualifiedByName = "hopEntityToHop")
    WarehouseNextHops fromEntity(WarehouseNextHopsEntity entity);
}
