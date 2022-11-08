package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipientRepository extends JpaRepository<RecipientEntity, Long> {

}
