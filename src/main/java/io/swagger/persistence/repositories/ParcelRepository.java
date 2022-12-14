package io.swagger.persistence.repositories;

import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.services.dto.TrackingInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {

    List<ParcelEntity> findByTrackingId(String trackingId);

}
