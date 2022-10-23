package io.swagger.model.entities;

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

public class WarehouseEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Integer level;

    @Column
    @OneToMany(mappedBy = "nextHops")
    private List<WarehouseEntityModel> nextHops = new ArrayList();



}
