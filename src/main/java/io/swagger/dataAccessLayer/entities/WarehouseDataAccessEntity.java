package io.swagger.dataAccessLayer.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "warehouse")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class WarehouseDataAccessEntity extends HopDataAccessEntity {

    @Column
    private Integer level;

    @Column
    @OneToMany(mappedBy = "nextHops")
    private List<WarehouseDataAccessEntity> nextHops = new ArrayList();



}
