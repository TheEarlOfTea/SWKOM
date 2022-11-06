package io.swagger.persistence.entities;


import lombok.*;

import javax.persistence.*;

@Entity
//todo: welcher table oder ist das ein fehler
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter

//Todo: clarify manytomany stuff
public class WarehouseNextHopsEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private Integer traveltimeMins;

    @OneToOne
    //@JoinColumn(name = "t_hops")
    private HopEntity hop;

    @ManyToOne
    //@JoinTable(name = "t_nextHops")
    private WarehouseEntity warehouse;



}
