package io.swagger.model.repositories;

import io.swagger.model.entities.NewParcelInfoEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface NewParcelInfoRepository extends JpaRepository<NewParcelInfoEntityModel, Long> {
    Optional<NewParcelInfoEntityModel> findById(long along);

    @Override
    <$ extends NewParcelInfoEntityModel> $ save($ entity);

    @Override
    List<NewParcelInfoEntityModel> findAll();

    @Override
    void deleteById(Long along);
}
