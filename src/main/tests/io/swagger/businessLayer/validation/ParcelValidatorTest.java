package io.swagger.businessLayer.validation;

import io.swagger.model.HopArrival;
import io.swagger.model.Recipient;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.TrackingInformation;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ParcelValidatorTest extends TestCase {



    @Test
    public void testIncorrectParcel() {
        ParcelEntity entity= ParcelEntity.builder().build();
        assertFalse(ParcelValidator.validateParcel(entity));
    }
    public void testCorrectParcel(){
        ParcelEntity entity=ParcelEntity.builder().trackingId("12345678A").weight(1.0f).recipient(mock(Recipient.class)).sender(mock(Recipient.class)).state(TrackingInformation.StateEnum.DELIVERED).visitedHops(mock(List.class)).futureHops(mock(List.class)).build();
        assert(ParcelValidator.validateParcel(entity));
    }
}