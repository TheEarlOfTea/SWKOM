package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Todo: join tabelle
public class WarehouseEntity extends HopEntity {

    @Column
    private Integer level;

    @Column
    @OneToMany
    private List<WarehouseEntity> nextHops = new ArrayList();



}
