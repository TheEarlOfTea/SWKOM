package io.swagger.businessLayer.mappers;

import io.swagger.businessLayer.entities.ErrorBusinessEntity;
import io.swagger.services.dto.Error;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorMapperTest {

    private Error error= new Error().errorMessage("testmessage");

    @Test
    void fromDTO() {
        ErrorBusinessEntity entity= ErrorMapper.INSTANCE.fromDTO(error);
        assertEquals(error.getErrorMessage(), entity.getErrorMessage());
    }

    @Test
    void fromEntity() {
        ErrorBusinessEntity entity= ErrorMapper.INSTANCE.fromDTO(error);
        Error newError= ErrorMapper.INSTANCE.fromEntity(entity);
        assertEquals(entity.getErrorMessage(), newError.getErrorMessage());
    }
}