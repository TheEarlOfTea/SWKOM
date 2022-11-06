package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;


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
    private Double lat;

    @Column
    private Double lon;

}


