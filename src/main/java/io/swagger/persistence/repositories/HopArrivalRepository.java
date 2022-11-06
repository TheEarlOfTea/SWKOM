package io.swagger.persistence.repositories;



import io.swagger.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Long> {



}
