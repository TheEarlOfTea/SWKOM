package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {

}
