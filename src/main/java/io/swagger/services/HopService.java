package io.swagger.services;

import io.swagger.services.dto.Hop;

import java.util.List;

public interface HopService {

        void saveHop(Hop hop);
        List<Hop> findAllHops();
        void deleteHopById(long id);
        Hop getHopById(long id);


}
