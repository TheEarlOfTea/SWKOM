package io.swagger.dataAccessLayer.entities;

import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.Recipient;
import io.swagger.services.dto.TrackingInformation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "parcel")
@Getter
@Setter
//TODO: fix the manytoone and stuff
public class ParcelDataAccessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String trackingId;
    @Column
    private float weight;
    @Column
    @ManyToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientDataAccessEntity recipient;
    @Column
    @ManyToOne
    @JoinColumn(name = "fk_sender")
    private RecipientDataAccessEntity sender;
    @Column
    private TrackingInformation.StateEnum state;
    @Column
    @ManyToMany
    private List<HopArrivalDataAccessEntity> visitedHops;
    @Column
    @ManyToMany
    private List<HopArrivalDataAccessEntity> futureHops;
}
