package io.swagger.businessLayer.validation;

import io.swagger.persistence.entity.FullParcelEntity;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.persistence.entity.WarehouseEntity;
import io.swagger.services.dto.Warehouse;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Log4j2
public class WarehouseValidator {
    private static Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean validateWarehouse(WarehouseEntity warehouse) {
        Set<ConstraintViolation<WarehouseEntity>> violations = validator.validate(warehouse);
        for (ConstraintViolation<WarehouseEntity> violation : violations) {
            log.error(violation.getMessage());
        }
        if(violations.isEmpty()){
            return true;
        }
        return false;
    }
}
