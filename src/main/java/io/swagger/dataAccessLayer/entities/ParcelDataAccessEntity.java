package io.swagger.dataAccessLayer.entities;

import io.swagger.services.dto.HopArrival;
import io.swagger.services.dto.Recipient;
import io.swagger.services.dto.TrackingInformation;

import javax.persistence.*;
import java.util.List;

@Entity(name = "parcel")
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
    private Recipient recipient;
    @Column
    private Recipient sender;
    @Column
    private TrackingInformation.StateEnum state;
    @Column
    private List<HopArrival> visitedHops;
    @Column
    private List<HopArrival> futureHops;
}
