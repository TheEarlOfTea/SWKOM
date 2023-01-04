package at.fhtw.swen3.services.validation;

import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import java.util.Set;

public class Validator {
    private static javax.validation.Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static void validate(Object o) throws ValidationException{
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if(!violations.isEmpty()){
            StringBuilder builder= new StringBuilder();
            builder.append("Following Validation errors were encountered:\n");
            for (ConstraintViolation<Object> violation : violations) {
                builder.append("Message: " + violation.getMessage() + "; Propertypath: " + violation.getPropertyPath()+ "\n");
            }
            throw new ValidationException(builder.toString());
        }
    }
}
