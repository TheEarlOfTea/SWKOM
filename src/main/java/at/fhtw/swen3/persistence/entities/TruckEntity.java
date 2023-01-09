package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.geo.Polygon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TruckEntity extends HopEntity {

    @Column(columnDefinition = "text")
    @Lob
    @NotNull(message = "regionGeoJson may not be null")
    private Polygon regionGeoJson;

    @Column
    @NotNull(message = "numberPlate may not be null")
    private String numberPlate;


}
