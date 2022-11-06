package io.swagger.persistence.entities;

import io.swagger.services.dto.TrackingInformation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name="t_parcels")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String trackingId;
    @Column
    private float weight;
    @ManyToOne
    //@JoinColumn(name = "fk_recipients")
    private RecipientEntity recipient;
    @ManyToOne
    //@JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
    @Column
    private TrackingInformation.StateEnum state;
    @ManyToMany(targetEntity = HopArrivalEntity.class)
    //@JoinTable(name="t_visitedHops")
    private List<HopArrivalEntity> visitedHops;
    @ManyToMany(targetEntity = HopArrivalEntity.class)
    //@JoinTable(name="t_futureHops")
    private List<HopArrivalEntity> futureHops;
}
