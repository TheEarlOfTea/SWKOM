package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.TransferwarehouseDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface TransferwarehouseRepository extends JpaRepository<TransferwarehouseDataAccessEntity, Long> {
    Optional<TransferwarehouseDataAccessEntity> findById(long along);

    @Override
    <$ extends TransferwarehouseDataAccessEntity> $ save($ entity);

    @Override
    List<TransferwarehouseDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
