package io.swagger.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class WarehouseEntity extends HopEntity {

    @Column
    @NotNull(message = "level may not be null")
    @Min(value = 0, message = "level must be 0 or higher")
    private Integer level;

    @Column
    @OneToMany
    @NotNull(message = "may not be null")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList();



}
