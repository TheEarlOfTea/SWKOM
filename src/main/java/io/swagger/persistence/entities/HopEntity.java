package io.swagger.persistence.entities;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_hops")
@Builder
@Getter
@Setter

//todo: fix geocoordinate
public class HopEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String hopType;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @Column
    private Point locationCoordinates;



}
