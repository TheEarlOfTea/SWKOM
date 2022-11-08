package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HopRepository extends JpaRepository<HopEntity, Long> {

}
