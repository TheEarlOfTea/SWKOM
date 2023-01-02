package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface HopRepository extends JpaRepository<HopEntity, Long> {

    List<HopEntity> findByCode(String code);
    Boolean existsByCode(String code);

    @Query(value = "SELECT hop_type FROM t_hops WHERE code = ?1", nativeQuery = true)
    Optional<String> getHoptypeByCode(String code);

}
