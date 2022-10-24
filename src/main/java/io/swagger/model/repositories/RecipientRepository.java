package io.swagger.model.repositories;

import io.swagger.model.entities.RecipientEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface RecipientRepository extends JpaRepository<RecipientEntityModel, Long> {
    Optional<RecipientEntityModel> findById(long along);

    @Override
    <$ extends RecipientEntityModel> $ save($ entity);

    @Override
    List<RecipientEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
