package io.swagger.persistence.entity;
import io.swagger.services.dto.Recipient;
import io.swagger.services.dto.HopArrival;
import java.util.List;
import io.swagger.services.dto.TrackingInformation.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelEntity {
    @Pattern(regexp="^[A-Z0-9]{9}$", message = "has to match \'^[A-Z0-9]{9}$\'")
    @NotNull(message = "trackingId may not be null")
    private String trackingId;
    @DecimalMin(value="0.001", message="parcels must weight at least 1 gram")
    private float weight;
    @NotNull(message= "recipient cannot be null")
    private Recipient recipient;
    @NotNull(message= "sender cannot be null")
    private Recipient sender;
    @NotNull(message= "state cannot be null")
    private StateEnum state;
    @NotNull(message= "visitedHops cannot be null")
    private List<HopArrival> visitedHops;
    @NotNull(message= "futureHops cannot be null")
    private List<HopArrival> futureHops;

    @Override
    public String toString() {
        return "ParcelEntity{" +                "trackingId='" + trackingId + '\'' +
                ", weight=" + weight +
                ", recipient=" + recipient +
                ", sender=" + sender +
                ", state=" + state +
                ", visitedHops=" + visitedHops +
                ", futureHops=" + futureHops +
                '}';
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
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

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public List<HopArrival> getVisitedHops() {
        return visitedHops;
    }

    public void setVisitedHops(List<HopArrival> visitedHops) {
        this.visitedHops = visitedHops;
    }

    public List<HopArrival> getFutureHops() {
        return futureHops;
    }

    public void setFutureHops(List<HopArrival> futureHops) {
        this.futureHops = futureHops;
    }
}
