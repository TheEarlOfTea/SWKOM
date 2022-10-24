package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.WarehouseDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface WarenhouseRepository extends JpaRepository<WarehouseDataAccessEntity, Long> {
    Optional<WarehouseDataAccessEntity> findById(long along);

    @Override
    <$ extends WarehouseDataAccessEntity> $ save($ entity);

    @Override
    List<WarehouseDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
