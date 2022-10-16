package io.swagger.businessLayer.validation;

import io.swagger.mapper.CodeMapper;
import io.swagger.persistence.entity.CodeEntity;
import junit.framework.TestCase;

public class CodeValidatorTest extends TestCase {

    String wrightCode1= "ABCD1234";
    String wrightCode2= "ABCD12";
    String wrongCode1= "AB";
    String wrongCode2= "ABCD12345";
    String wrongCode3= "ABC%1234";

    CodeEntity wrightCodeEntity1;
    CodeEntity wrightCodeEntity2;
    CodeEntity wrongCodeEntity1;
    CodeEntity wrongCodeEntity2;
    CodeEntity wrongCodeEntity3;

    void setup() {
        wrightCodeEntity1 = CodeMapper.INSTANCE.from(wrightCode1);
        wrightCodeEntity2 = CodeMapper.INSTANCE.from(wrightCode2);
        wrongCodeEntity1 = CodeMapper.INSTANCE.from(wrongCode1);
        wrongCodeEntity2 = CodeMapper.INSTANCE.from(wrongCode2);
        wrongCodeEntity3 = CodeMapper.INSTANCE.from(wrongCode3);
    }

    public void testVaildateNewParcelInfo() {
        setup();

        assert(CodeValidator.vaildateNewParcelInfo(wrightCodeEntity1));
        assert(CodeValidator.vaildateNewParcelInfo(wrightCodeEntity2));
        assertFalse(CodeValidator.vaildateNewParcelInfo(wrongCodeEntity1));
        assertFalse(CodeValidator.vaildateNewParcelInfo(wrongCodeEntity2));
        assertFalse(CodeValidator.vaildateNewParcelInfo(wrongCodeEntity3));
    }
}