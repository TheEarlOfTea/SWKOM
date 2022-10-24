package io.swagger.businessLayer.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter @Setter
@Data

public class TransferwarehouseEntity extends HopEntity{
    private String regionGeoJson;
    private String logisticsPartner;
    private String logisticsPartnerUrl;
}
