package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface WarenhouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {

}
