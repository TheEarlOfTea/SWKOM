package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {

    List<WarehouseEntity> findByCode(String code);
    List<WarehouseEntity> findByLevel(int level);
    Optional<WarehouseEntity> findByLocationCoordinates(GeoCoordinate geoCoordinate);

}