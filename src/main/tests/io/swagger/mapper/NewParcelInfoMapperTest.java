package io.swagger.mapper;

import io.swagger.persistence.entity.NewParcelInfoEntity;
import io.swagger.services.dto.NewParcelInfo;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class NewParcelInfoMapperTest extends TestCase {

    private NewParcelInfo info= new NewParcelInfo();
    private String id= "123456789";

    @Test
    public void testFromWithDto() {
        info.setTrackingId(id);
        NewParcelInfoEntity entity= NewParcelInfoMapper.INSTANCE.from(info);
        assertEquals(info.getTrackingId(), entity.getTrackingId());
    }

    @Test
    public void testFromWithString(){
        NewParcelInfoEntity entity= NewParcelInfoMapper.INSTANCE.from(id);
        assertEquals(id, entity.getTrackingId());
    }
}