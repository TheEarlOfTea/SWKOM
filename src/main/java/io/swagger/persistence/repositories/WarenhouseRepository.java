package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface WarenhouseRepository extends JpaRepository<WarehouseEntity, Long> {

}
