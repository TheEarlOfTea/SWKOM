package io.swagger.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;


import javax.persistence.*;

@Entity(name = "Hop")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"locationCoordinates"})


public class HopEntityModel {
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
    @Type(type="")//

    private Point locationCoordinates;



}
