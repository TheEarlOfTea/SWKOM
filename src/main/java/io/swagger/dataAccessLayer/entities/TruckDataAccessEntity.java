package io.swagger.dataAccessLayer.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Truck")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TruckDataAccessEntity extends HopDataAccessEntity {

    @Column
    private String regionGeoJson;
    @Column
    private String numberPlate;


}
