package io.swagger.persistence.entity;
import io.swagger.model.Recipient;
import io.swagger.model.HopArrival;
import java.util.List;
import io.swagger.services.dto.TrackingInformation.StateEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class ParcelEntity {

    private String trackingId;

    private float weight;
    private Recipient recipient;
    private Recipient sender;

    private StateEnum state;
    private List<HopArrival> visitedHops;
    private List<HopArrival> futureHops;


}
