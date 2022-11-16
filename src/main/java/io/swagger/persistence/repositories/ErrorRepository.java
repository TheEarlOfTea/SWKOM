package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ErrorRepository extends JpaRepository<ErrorEntity, Long> {

}
