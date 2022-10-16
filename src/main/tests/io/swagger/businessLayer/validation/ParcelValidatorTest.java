package io.swagger.businessLayer.validation;

import io.swagger.mapper.ParcelMapper;
import io.swagger.model.Recipient;
import io.swagger.persistence.entity.ParcelEntity;
import io.swagger.services.dto.Parcel;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ParcelValidatorTest extends TestCase {

    private Parcel correctParcel= new Parcel();
    private Parcel falseParcel1= new Parcel();
    private Parcel falseParcel2= new Parcel();

    private ParcelEntity correctEntity;
    private ParcelEntity falseEntity1;
    private ParcelEntity falseEntity2;

    private void setup(){
        correctParcel.setWeight(10.0f);
        correctParcel.setRecipient(Mockito.mock(Recipient.class));
        correctParcel.setSender(Mockito.mock(Recipient.class));
        correctEntity= ParcelMapper.INSTANCE.from(correctParcel);

        falseParcel1.setWeight(10.0f);
        falseEntity1= ParcelMapper.INSTANCE.from(falseParcel1);

        falseParcel2.setSender(Mockito.mock(Recipient.class));
        falseParcel2.setRecipient(Mockito.mock(Recipient.class));
        falseEntity2= ParcelMapper.INSTANCE.from(falseParcel2);
    }

    @Test
    public void testValidateParcel() {
        setup();
        assert(ParcelValidator.validateParcel(correctEntity));
        assertFalse(ParcelValidator.validateParcel(falseEntity1));
        assertFalse(ParcelValidator.validateParcel(falseEntity2));
    }
}