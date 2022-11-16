package io.swagger.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TransferwarehouseEntity extends HopEntity {

    @Column
    @NotNull(message = "regiongGeoJson may not be null")
    private String regionGeoJson;

    @Column
    @NotNull(message = "logisticsPartner may not be null")
    private String logisticsPartner;

    @Column
    @NotNull(message = "logisticsPartnerUrl may not be null")
    private String logisticsPartnerUrl;


}
