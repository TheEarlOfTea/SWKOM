package io.swagger.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Truck")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TruckEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String regionGeoJson;
    @Column
    private String numberPlate;


}
