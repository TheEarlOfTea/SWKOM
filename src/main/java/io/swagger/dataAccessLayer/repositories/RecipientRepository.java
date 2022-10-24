package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.RecipientDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface RecipientRepository extends JpaRepository<RecipientDataAccessEntity, Long> {
    Optional<RecipientDataAccessEntity> findById(long along);

    @Override
    <$ extends RecipientDataAccessEntity> $ save($ entity);

    @Override
    List<RecipientDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);
}
