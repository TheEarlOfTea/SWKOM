package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.TruckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TruckRepository extends JpaRepository<TruckEntity, Long> {

}
