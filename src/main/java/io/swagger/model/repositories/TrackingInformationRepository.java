package io.swagger.model.repositories;

import io.swagger.model.entities.TrackingInformationEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TrackingInformationRepository extends JpaRepository<TrackingInformationEntityModel, Long> {
    Optional<TrackingInformationEntityModel> findById(long along);

    @Override
    <$ extends TrackingInformationEntityModel> $ save($ entity);

    @Override
    List<TrackingInformationEntityModel> findAll();

    @Override
    void deleteById(Long along);
}