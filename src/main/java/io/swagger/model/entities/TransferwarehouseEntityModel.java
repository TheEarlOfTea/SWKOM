package io.swagger.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Transferwarehouse")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TransferwarehouseEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;


}
