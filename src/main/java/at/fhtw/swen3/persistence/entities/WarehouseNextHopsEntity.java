package at.fhtw.swen3.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_warehouseNextHops")
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class WarehouseNextHopsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @NotNull(message = "traveltimeMins may not be null")
    @Min(value = 1, message = "traveltimeMins may not be lower than 1")
    private Integer traveltimeMins;

    @OneToOne
    @JoinColumn(name = "fk_next_hop")
    private HopEntity hop;

    @ManyToOne
    @JoinColumn(name = "fk_warehouse")
    private WarehouseEntity warehouse;
}
