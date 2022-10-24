package io.swagger.model.repositories;

import io.swagger.model.entities.HopEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HopRepository extends JpaRepository<HopEntityModel, Long> {


        Optional<HopEntityModel> findById(long along);

        @Override
        <$ extends HopEntityModel> $ save($ entity);

        @Override
        List<HopEntityModel> findAll();

        @Override
        void deleteById(Long along);
}
