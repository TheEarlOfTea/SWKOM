package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorMapperTest {

    private Error error= new Error().errorMessage("testmessage");

    @Test
    void fromDTO() {

        ErrorEntity entity= ErrorMapper.INSTANCE.fromDTO(error);
        assertEquals(error.getErrorMessage(), entity.getErrorMessage());
    }

    @Test
    void fromEntity() {
        ErrorEntity entity= ErrorMapper.INSTANCE.fromDTO(error);
        Error newError= ErrorMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getErrorMessage(), newError.getErrorMessage());
    }
}