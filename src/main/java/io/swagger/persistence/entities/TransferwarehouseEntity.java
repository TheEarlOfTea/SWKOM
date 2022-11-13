package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_transferwarehouses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferwarehouseEntity extends HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

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
