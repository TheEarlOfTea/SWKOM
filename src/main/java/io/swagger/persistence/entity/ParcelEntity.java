package io.swagger.persistence.entity;

import io.swagger.model.Recipient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelEntity {
    @DecimalMin(value="0.001", message="parcels must weight at least 1 gram")
    private float weight;
    @NotNull(message= "recipient cannot be null")
    private Recipient recipient;
    @NotNull(message= "sender cannot be null")
    private Recipient sender;

    @Override
    public String toString() {
        return "ParcelEntity{" +
                "weight=" + weight +
                ", recipient=" + recipient +
                ", sender=" + sender +
                '}';
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Recipient getSender() {
        return sender;
    }

    public void setSender(Recipient sender) {
        this.sender = sender;
    }
}
