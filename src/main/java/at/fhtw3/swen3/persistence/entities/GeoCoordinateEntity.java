package at.fhtw3.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="t_geocoordinates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder
public class GeoCoordinateEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @NotNull(message = "lat may not be null")
    @DecimalMin(value="-180.0000000", message="latitude cannot be less than -180")
    @DecimalMax(value="180.0000000", message="latitude cannot be higher than 180")
    private Double lat;

    @Column
    @NotNull(message = "lon may not be null")
    @DecimalMin(value="-180.0000000", message="longitude cannot be less than -180")
    @DecimalMax(value="180.0000000", message="longitude cannot be higher than 180")
    private Double lon;

}


