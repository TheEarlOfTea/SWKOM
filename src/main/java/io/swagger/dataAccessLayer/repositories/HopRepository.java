package io.swagger.dataAccessLayer.repositories;

import io.swagger.dataAccessLayer.entities.HopDataAccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HopRepository extends JpaRepository<HopDataAccessEntity, Long> {


        Optional<HopDataAccessEntity> findById(long along);

        @Override
        <$ extends HopDataAccessEntity> $ save($ entity);

        @Override
        List<HopDataAccessEntity> findAll();

        @Override
        void deleteById(Long along);
}
