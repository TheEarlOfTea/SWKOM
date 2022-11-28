package io.swagger.services.impl;

import io.swagger.persistence.entities.ParcelEntity;
import io.swagger.persistence.repositories.ParcelRepository;
import io.swagger.services.ParcelService;
import io.swagger.services.dto.Parcel;
import io.swagger.services.mapper.ParcelMapper;
import io.swagger.services.mapper.RecipientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TODO: Services nicht an repositories anpassen, sondern mit sprechenden methoden
@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository repository;

    @Override
    public void save(ParcelEntity entity) {
        repository.save(entity);

    }

    @Override
    public List<Parcel> findAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Parcel getById(long id) {

        Optional<ParcelEntity> entity= repository.findById(id);
        return ParcelMapper.INSTANCE.fromEntity(entity.get());
    }

    @Override
    public Parcel findByTrackingId(String trackingId) {
        System.out.println(trackingId);
        try {
            ParcelEntity entity=repository.findByTrackingId(trackingId).get(0);
            return ParcelMapper.INSTANCE.fromEntity(entity);
        }catch (IndexOutOfBoundsException e){

        }

        return null;
    }
}
