package at.fhtw3.swen3.persistence.repositories;



import at.fhtw3.swen3.persistence.entities.HopArrivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HopArrivalRepository extends JpaRepository<HopArrivalEntity, Long> {



}
