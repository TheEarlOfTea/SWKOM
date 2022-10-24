package io.swagger.model.repositories;

import io.swagger.model.entities.TruckEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TruckRepository extends JpaRepository<TruckEntityModel, Long> {
    Optional<TruckEntityModel> findById(long along);

    @Override
    <$ extends TruckEntityModel> $ save($ entity);

    @Override
    List<TruckEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
