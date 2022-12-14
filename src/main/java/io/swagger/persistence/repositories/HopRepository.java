package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HopRepository extends JpaRepository<HopEntity, Long> {

    List<HopEntity> findByCode(String code);

}
