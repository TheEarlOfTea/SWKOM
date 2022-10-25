package io.swagger.dataAccessLayer.entities;


import io.swagger.services.dto.Hop;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "WarehouseNextHops")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"hop","warehouse"})

//Todo: clarify manytomany stuff
public class WarehouseNextHopsDataAccessEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private Integer traveltimeMins;

    @Column
    @OneToOne
    @JoinColumn(name = "fk_hop")
    private Hop hop;

    @Column
    @ManyToMany
    @JoinColumn(name = "warehouse_id",nullable = false,updatable = false)
    private WarehouseDataAccessEntity warehouse;



}
