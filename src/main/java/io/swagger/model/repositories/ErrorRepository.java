package io.swagger.model.repositories;

import io.swagger.model.entities.ErrorEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ErrorRepository extends JpaRepository<ErrorEntityModel, Long> {
    //
    Optional<ErrorEntityModel> findById(long along);

    @Override
    <$ extends ErrorEntityModel> $ save($ entity);

    @Override
    List<ErrorEntityModel> findAll();

    @Override
    void deleteById(Long along);


}
