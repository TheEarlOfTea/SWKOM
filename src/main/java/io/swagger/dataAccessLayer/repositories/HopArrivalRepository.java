package io.swagger.dataAccessLayer.repositories;



import io.swagger.dataAccessLayer.entities.HopArrivalDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HopArrivalRepository extends JpaRepository<HopArrivalDataAccessEntity, Long> {


    Optional<HopArrivalDataAccessEntity> findById(long along);

    @Override
    <$ extends HopArrivalDataAccessEntity> $ save($ entity);

    @Override
    List<HopArrivalDataAccessEntity> findAll();

    @Override
    void deleteById(Long along);


}
