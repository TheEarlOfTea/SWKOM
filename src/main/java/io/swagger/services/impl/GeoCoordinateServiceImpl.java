package io.swagger.services.impl;

import io.swagger.persistence.entities.GeoCoordinateEntity;
import io.swagger.persistence.repositories.GeoCoordinateRepository;
import io.swagger.services.GeoCoordinateService;
import io.swagger.services.dto.GeoCoordinate;
import io.swagger.services.mapper.GeoCoordinateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GeoCoordinateServiceImpl implements GeoCoordinateService {
    @Autowired
    private GeoCoordinateRepository geoCoordinateRepository;
    @Autowired
    private GeoCoordinateMapper geoCoordinateMapper;

    // Save operation
    @Override
    public GeoCoordinateEntity saveGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        return geoCoordinateRepository.save(geoCoordinateMapper.fromDTO(geoCoordinate));
    }


    // Read operation
    @Override public List<GeoCoordinate> fetchGeoCoordinateEntityList() {
        List<GeoCoordinate> geoCoordinates = new LinkedList<>();
        for (GeoCoordinateEntity geoCoordinateEntity:geoCoordinateRepository.findAll()) {
            geoCoordinates.add(geoCoordinateMapper.fromEntity(geoCoordinateEntity));
        }
        return geoCoordinates;
    }

    @Override
    public void getAllGeoCoordinateEntity(GeoCoordinate geoCoordinate) {

    }

    @Override
    public void findGeoCoordinateEntityByIdAll(Long geoCoordinateId) {

    }


    // Delete operation
    @Override
    public void deleteGeoCoordinateEntityById(Long Id){
        geoCoordinateRepository.deleteById(Id);
    }
}
