package io.swagger.services.impl;
import java.util.LinkedList;
import java.util.List;

import io.swagger.persistence.entities.HopEntity;
import io.swagger.persistence.repositories.HopRepository;
import io.swagger.services.HopService;
import io.swagger.services.dto.Hop;
import io.swagger.services.mapper.HopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HopServiceImpl implements HopService {

        @Autowired
        private HopRepository hopRepository;
        @Autowired
        private HopMapper hopMapper;

        // Save operation
        @Override
        public HopEntity saveHopEntity(Hop hop) {
                return hopRepository.save(hopMapper.fromDTO(hop));
        }


        // Read operation
        @Override public List<Hop> fetchHopEntityList() {
                List<Hop> hops = new LinkedList<>();
                for (HopEntity hopEntity:hopRepository.findAll()) {
                        hops.add(hopMapper.fromEntity(hopEntity));
                }
                return hops;
        }


        // Delete operation
        @Override
        public void deleteHopEntityById(Long Id){
                hopRepository.deleteById(Id);
        }

        @Override
        public void getAllHopEntity(Hop hop) {
        }

        @Override
        public void findHopEntityByIdAll(Long hopId) {
        }


}
