package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.PredictService;
import at.fhtw.swen3.services.PredictionService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.PredictionServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("at.fhtw.swen3")
public class DependencyInjectionConfig {

    @Autowired
    private ParcelRepository parcelRepository;
    @Autowired
    private RecipientRepository recipientRepository;
    @Autowired
    private HopArrivalRepository hopArrivalRepository;
    @Autowired
    private HopRepository hopRepository;
    @Autowired
    private WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Bean
    public ParcelService parcelService(){
        return new ParcelServiceImpl(parcelRepository, recipientRepository, hopArrivalRepository, hopRepository, predictionService());
    }

    @Bean
    public WarehouseService warehouseService(){
        return new WarehouseServiceImpl(hopRepository, warehouseNextHopsRepository, warehouseRepository);
    }

    @Bean
    public PredictionService predictionService(){
        return new PredictionServiceImpl(hopRepository, warehouseRepository);
    }
}
