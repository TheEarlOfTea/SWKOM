package io.swagger.dataAccessLayer.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Transferwarehouse")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TransferwarehouseDataAccessEntity extends HopDataAccessEntity {

    @Column
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;


}
