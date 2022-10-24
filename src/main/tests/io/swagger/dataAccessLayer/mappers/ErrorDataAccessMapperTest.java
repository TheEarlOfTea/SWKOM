package io.swagger.dataAccessLayer.mappers;

import io.swagger.businessLayer.entities.ErrorBusinessEntity;
import io.swagger.dataAccessLayer.entities.ErrorDataAccessEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorDataAccessMapperTest {

    ErrorBusinessEntity businessEntity= new ErrorBusinessEntity("test");

    @Test
    void fromBusinessEntity() {
        ErrorDataAccessEntity model= ErrorDataAccessMapper.INSTANCE.fromBusinessEntity(businessEntity);
        assertEquals(businessEntity.getErrorMessage(), model.getErrorMessage());
    }

    @Test
    void fromDataAccessEntity() {
        ErrorDataAccessEntity model= ErrorDataAccessMapper.INSTANCE.fromBusinessEntity(businessEntity);
        ErrorBusinessEntity entity= ErrorDataAccessMapper.INSTANCE.fromDataAccessEntity(model);
        assertEquals(model.getErrorMessage(), entity.getErrorMessage());
    }
}