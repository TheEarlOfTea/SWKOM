package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import io.swagger.persistence.entities.GeoCoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateEntity, Long> {

}
