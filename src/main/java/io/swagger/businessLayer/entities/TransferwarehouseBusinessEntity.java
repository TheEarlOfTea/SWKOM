package io.swagger.businessLayer.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class TransferwarehouseBusinessEntity extends HopBusinessEntity {
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;
}
