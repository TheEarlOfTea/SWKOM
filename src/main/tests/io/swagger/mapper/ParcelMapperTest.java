package io.swagger.mapper;

import io.swagger.model.Recipient;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.Parcel;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ParcelMapperTest extends TestCase {

    private Parcel parcel= new Parcel();

    @Test
    public void testFrom() {
        parcel.setSender(Mockito.mock(Recipient.class));
        parcel.setRecipient(Mockito.mock(Recipient.class));
        parcel.setWeight(1.0f);

        ParcelEntity entity= ParcelMapper.INSTANCE.from(parcel);

        assertEquals(parcel.getWeight(), entity.getWeight());
        assertEquals(parcel.getSender(), entity.getSender());
        assertEquals(parcel.getRecipient(), entity.getRecipient());
    }
}