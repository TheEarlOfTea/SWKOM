package io.swagger.businessLayer.validation;

import io.swagger.mapper.NewParcelInfoMapper;
import io.swagger.persistence.entity.NewParcelInfoEntity;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class NewParcelInfoValidatorTest extends TestCase {

    NewParcelInfoEntity correctEntity= NewParcelInfoMapper.INSTANCE.from("123456789");
    NewParcelInfoEntity falseEntitty= NewParcelInfoMapper.INSTANCE.from("123489");
    NewParcelInfoEntity falseEntitty2= NewParcelInfoMapper.INSTANCE.from("123489asdfasdf");
    NewParcelInfoEntity falseEntitty3= NewParcelInfoMapper.INSTANCE.from("1234%6789");

    @Test
    public void testVaildateNewParcelInfo() {
        assert(NewParcelInfoValidator.vaildateNewParcelInfo(correctEntity));
        assertFalse(NewParcelInfoValidator.vaildateNewParcelInfo(falseEntitty));
        assertFalse(NewParcelInfoValidator.vaildateNewParcelInfo(falseEntitty2));
        assertFalse(NewParcelInfoValidator.vaildateNewParcelInfo(falseEntitty3));
    }
}