package io.swagger.businessLayer.validation;

import io.swagger.persistence.entity.ParcelEntity;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

@Log4j2
public class ParcelValidator {
    private static Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean validateParcel(ParcelEntity parcel) {
        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(parcel);
        for (ConstraintViolation<ParcelEntity> violation : violations) {
            log.error(violation.getMessage());
        }
        if(violations.isEmpty()){
            return true;
        }
        return false;
    }
}
