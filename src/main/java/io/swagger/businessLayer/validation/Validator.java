package io.swagger.businessLayer.validation;
import lombok.extern.log4j.Log4j2;

import javax.validation.*;
import java.util.Set;

@Log4j2
public class Validator {
    private static javax.validation.Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static void validate(Object o) throws ValidationException{
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            log.error("Message: " + violation.getMessage() + "; Propertypath: " + violation.getPropertyPath());
        }
        if(!violations.isEmpty()){
            throw new ValidationException();
        }
    }
}
