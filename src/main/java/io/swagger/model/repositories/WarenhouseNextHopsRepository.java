package io.swagger.model.repositories;

import io.swagger.model.entities.WarehouseNextHopsEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface WarenhouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntityModel, Long> {
    Optional<WarehouseNextHopsEntityModel> findById(long along);

    @Override
    <$ extends WarehouseNextHopsEntityModel> $ save($ entity);

    @Override
    List<WarehouseNextHopsEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
