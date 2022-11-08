package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_trucks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TruckEntity extends HopEntity {

    @Column
    private String regionGeoJson;
    @Column
    private String numberPlate;


}
