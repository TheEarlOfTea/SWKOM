package io.swagger.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
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
