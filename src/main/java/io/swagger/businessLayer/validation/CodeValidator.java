package io.swagger.businessLayer.validation;

import io.swagger.persistence.entity.CodeEntity;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Log4j2
public class CodeValidator {
    private static Validator validator= Validation.buildDefaultValidatorFactory().getValidator();

    public static boolean vaildateNewParcelInfo(CodeEntity code) {
        Set<ConstraintViolation<CodeEntity>> violations = validator.validate(code);
        for (ConstraintViolation<CodeEntity> violation : violations) {
            log.error(violation.getMessage());
        }
        if(violations.isEmpty()){
            return true;
        }
        return false;
    }
}
