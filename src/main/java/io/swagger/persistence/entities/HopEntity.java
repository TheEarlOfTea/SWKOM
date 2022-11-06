package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    /*@Column
    @Type(type="")//

    private Point locationCoordinates;
*/


}
