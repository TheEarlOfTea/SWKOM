package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.WarehouseNextHopsDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface WarenhouseNextHopsRepository extends JpaRepository<WarehouseNextHopsDataAccessEntity, Long> {
    Optional<WarehouseNextHopsDataAccessEntity> findById(long along);

    @Override
    <$ extends WarehouseNextHopsDataAccessEntity> $ save($ entity);

    @Override
    List<WarehouseNextHopsDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
