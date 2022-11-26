package io.swagger.services.impl;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.persistence.repositories.ErrorRepository;
import io.swagger.persistence.repositories.GeoCoordinateRepository;
import io.swagger.services.GeoCoordinateService;
import io.swagger.services.dto.GeoCoordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GeoCoordinateServiceImpl implements GeoCoordinateService {

    @Autowired
    private GeoCoordinateRepository repository;

    @Override
    public void save(GeoCoordinateEntity entity) {
        repository.save(entity);
    }

    @Override
    public List<GeoCoordinateEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public GeoCoordinateEntity getById(long id) {
        Optional<GeoCoordinateEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        return null;
    }
}
