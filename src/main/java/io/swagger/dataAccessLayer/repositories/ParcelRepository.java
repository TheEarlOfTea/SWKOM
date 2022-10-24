package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.ParcelDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelDataAccessEntity, Long> {
    Optional<ParcelDataAccessEntity> findById(long along);

    @Override
    <$ extends ParcelDataAccessEntity> $ save($ entity);

    @Override
    List<ParcelDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
