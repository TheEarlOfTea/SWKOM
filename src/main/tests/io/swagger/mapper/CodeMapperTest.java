package io.swagger.mapper;

import io.swagger.persistence.entity.CodeEntity;
import junit.framework.TestCase;

public class CodeMapperTest extends TestCase {

    String code= "ABCD1";

    public void testFrom() {
        CodeEntity entity= CodeMapper.INSTANCE.from(code);
        assertEquals(code, entity.getCode());
    }
}