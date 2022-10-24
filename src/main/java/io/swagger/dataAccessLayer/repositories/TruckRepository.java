package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.TruckDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TruckRepository extends JpaRepository<TruckDataAccessEntity, Long> {
    Optional<TruckDataAccessEntity> findById(long along);

    @Override
    <$ extends TruckDataAccessEntity> $ save($ entity);

    @Override
    List<TruckDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
