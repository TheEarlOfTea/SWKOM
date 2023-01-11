package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface WarehouseNextHopsRepository extends JpaRepository<WarehouseNextHopsEntity, Long> {

    @Query(value = "select * from t_warehouse_next_hops where fk_next_hop = :hopId", nativeQuery = true)
    Optional<WarehouseNextHopsEntity> findByHopId(Long hopId);
}
