package io.swagger.businessLayer.validation;

import io.swagger.persistence.entity.FullParcelEntity;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Log4j2
public class FullParcelValidator {
    private static Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean validateFullParcel(FullParcelEntity parcel) {
        Set<ConstraintViolation<FullParcelEntity>> violations = validator.validate(parcel);
        for (ConstraintViolation<FullParcelEntity> violation : violations) {
            log.error(violation.getMessage());
        }
        if(violations.isEmpty()){
            return true;
        }
        return false;
    }
}
