package io.swagger.dataAccessLayer.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "warehouse")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
//Todo: join tabelle
public class WarehouseDataAccessEntity extends HopDataAccessEntity {

    @Column
    private Integer level;

    @Column
    @ManyToMany
    private List<WarehouseDataAccessEntity> nextHops = new ArrayList();



}
