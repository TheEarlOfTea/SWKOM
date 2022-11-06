package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;

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
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;


}
