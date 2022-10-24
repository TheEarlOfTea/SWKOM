package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.ErrorDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ErrorRepository extends JpaRepository<ErrorDataAccessEntity, Long> {

    Optional<ErrorDataAccessEntity> findById(long along);

    @Override
    <$ extends ErrorDataAccessEntity> $ save($ entity);

    @Override
    List<ErrorDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);


}
