package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ErrorRepository extends JpaRepository<ErrorEntity, Long> {

}
