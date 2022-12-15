package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.services.GeoCoordinateService;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.mapper.GeoCoordinateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GeoCoordinateServiceImpl implements GeoCoordinateService {

    @Autowired
    private GeoCoordinateRepository repository;

    @Override
    public void saveGeoCoordinate(GeoCoordinate geoCoordinate) {
        repository.save(GeoCoordinateMapper.INSTANCE.fromDTO(geoCoordinate));
    }

    @Override
    public List<GeoCoordinate> findAllGeoCoordinates() {
        List<GeoCoordinateEntity> list=repository.findAll();
        LinkedList<GeoCoordinate> returnList= new LinkedList<GeoCoordinate>();
        for(GeoCoordinateEntity e: list){
            returnList.add(GeoCoordinateMapper.INSTANCE.fromEntity(e));
        }
        return returnList;
    }

    @Override
    public void deleteGeoCoordinateById(long id) {
        repository.deleteById(id);
    }

    @Override
    public GeoCoordinate getGeoCoordinateById(long id) {
        Optional<GeoCoordinateEntity> entity= repository.findById(id);
        if(entity.isPresent()){
            return GeoCoordinateMapper.INSTANCE.fromEntity(entity.get());
        }
        return null;
    }
}
