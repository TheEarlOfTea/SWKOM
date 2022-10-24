package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.GeoCoordinateDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateDataAccessEntity, Long> {

    Optional<GeoCoordinateDataAccessEntity> findById(long along);

    @Override
    <$ extends GeoCoordinateDataAccessEntity> $ save($ entity);

    @Override
    List<GeoCoordinateDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);

}
