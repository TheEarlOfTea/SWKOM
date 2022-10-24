package io.swagger.model.repositories;



import io.swagger.model.entities.HopArrivalEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntityModel, Long> {


    Optional<HopArrivalEntityModel> findById(long along);

    @Override
    <$ extends HopArrivalEntityModel> $ save($ entity);

    @Override
    List<HopArrivalEntityModel> findAll();

    @Override
    void deleteById(Long along);


}
