package io.swagger.model.entities;

import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "trackingInformation")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"visitedHops","futureHops"})
@EqualsAndHashCode(exclude = {"visitedHops","futureHops"})
public class TrackingInformationEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private TrackingInformation.StateEnum state;

    @Column
    @OneToMany(mappedBy = "fk_visitedHop")
    private List<HopArrival> visitedHops = new ArrayList<>();

    @Column
    @OneToMany(mappedBy = "fk_futureHop")
    private List<HopArrival> futureHops = new ArrayList<>();



}
