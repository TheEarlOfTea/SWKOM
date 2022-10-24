package io.swagger.model.repositories;

import io.swagger.model.entities.GeoCoordinateEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface GeoCoordinateRepository extends JpaRepository<GeoCoordinateEntityModel, Long> {

    Optional<GeoCoordinateEntityModel> findById(long along);

    @Override
    <$ extends GeoCoordinateEntityModel> $ save($ entity);

    @Override
    List<GeoCoordinateEntityModel> findAll();

    @Override
    void deleteById(Long along);

}
