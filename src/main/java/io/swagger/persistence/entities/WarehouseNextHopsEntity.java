package io.swagger.persistence.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="t_warehouseNextHops")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter

public class WarehouseNextHopsEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private Integer traveltimeMins;

    @OneToOne
    @JoinColumn(name = "fk_hop")
    private HopEntity hop;

    @ManyToOne
    @JoinColumn(name = "fk_warehouse")
    private WarehouseEntity warehouse;



}
