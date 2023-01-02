package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FutureHopsRepository extends JpaRepository<HopArrivalEntity, Long> {


}