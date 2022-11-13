package io.swagger.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="t_geocoordinates")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GeoCoordinateEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull(message = "lat may not be null")
    @DecimalMin(value="-180.0000000", message="latitude cannot be less than -180")
    @DecimalMax(value="180.0000000", message="latitude cannot be higher than 180")
    private Double lat;

    @Column
    @NotNull(message = "lat may not be null")
    @DecimalMin(value="-180.0000000", message="longitude cannot be less than -180")
    @DecimalMax(value="180.0000000", message="longitude cannot be higher than 180")
    private Double lon;

}


