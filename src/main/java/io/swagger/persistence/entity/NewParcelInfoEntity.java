package io.swagger.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewParcelInfoEntity {
    @Pattern(regexp="^[A-Z0-9]{9}$", message = "has to match \'^[A-Z0-9]{9}$\'")
    @NotNull(message = "trackingId may not be null")
    private String trackingId;

    @Override
    public String toString() {
        return "NewParcelInfoEntity{" +
                "trackingId='" + trackingId + '\'' +
                '}';
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}
