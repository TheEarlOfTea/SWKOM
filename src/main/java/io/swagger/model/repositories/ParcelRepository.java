package io.swagger.model.repositories;

import io.swagger.model.entities.ParcelEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntityModel, Long> {
    Optional<ParcelEntityModel> findById(long along);

    @Override
    <$ extends ParcelEntityModel> $ save($ entity);

    @Override
    List<ParcelEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
