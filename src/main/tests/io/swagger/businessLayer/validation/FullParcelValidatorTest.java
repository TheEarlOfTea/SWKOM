package io.swagger.businessLayer.validation;

import io.swagger.model.Recipient;
import io.swagger.persistence.entity.FullParcelEntity;
import io.swagger.services.dto.TrackingInformation;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class FullParcelValidatorTest extends TestCase {



    @Test
    public void testIncorrectParcel() {
        FullParcelEntity entity= FullParcelEntity.builder().build();
        assertFalse(FullParcelValidator.validateFullParcel(entity));
    }
    public void testCorrectParcel(){
        FullParcelEntity entity= FullParcelEntity.builder().trackingId("12345678A").weight(1.0f).recipient(mock(Recipient.class)).sender(mock(Recipient.class)).state(TrackingInformation.StateEnum.DELIVERED).visitedHops(mock(List.class)).futureHops(mock(List.class)).build();
        assert(FullParcelValidator.validateFullParcel(entity));
    }
}