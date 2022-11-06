package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.TransferwarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseEntity, Long> {

}
