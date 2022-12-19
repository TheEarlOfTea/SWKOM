package at.fhtw3.swen3.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TruckEntity extends HopEntity {

    @Column
    @NotNull(message = "regionGeoJson may not be null")
    private String regionGeoJson;

    @Column
    @NotNull(message = "numberPlate may not be null")
    private String numberPlate;


}
