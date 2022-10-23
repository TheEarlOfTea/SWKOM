package io.swagger.model.entities;

import lombok.*;

import javax.persistence.*;


@Entity(name = "geoCoordinate")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GeoCoordinateEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;

    @Column
    private Double lat;

    @Column
    private Double aLong;

}


