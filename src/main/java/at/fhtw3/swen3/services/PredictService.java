package at.fhtw3.swen3.services;

import at.fhtw3.swen3.persistence.entities.ParcelEntity;
import at.fhtw3.swen3.services.dto.HopArrival;

import java.util.List;

public interface PredictService {
    List<HopArrival> predict(ParcelEntity parcelEntity);
}
