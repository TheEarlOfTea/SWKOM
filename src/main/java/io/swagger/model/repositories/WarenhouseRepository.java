package io.swagger.model.repositories;

import io.swagger.model.entities.WarehouseEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface WarenhouseRepository extends JpaRepository<WarehouseEntityModel, Long> {
    Optional<WarehouseEntityModel> findById(long along);

    @Override
    <$ extends WarehouseEntityModel> $ save($ entity);

    @Override
    List<WarehouseEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
