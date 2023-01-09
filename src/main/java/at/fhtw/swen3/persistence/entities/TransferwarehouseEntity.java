package at.fhtw.swen3.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TransferwarehouseEntity extends HopEntity {

    @Column
    @NotNull(message = "regiongGeoJson may not be null")
    @Lob
    private Polygon regionGeoJson;

    @Column
    @NotNull(message = "logisticsPartner may not be null")
    private String logisticsPartner;

    @Column
    @NotNull(message = "logisticsPartnerUrl may not be null")
    private String logisticsPartnerUrl;


}
