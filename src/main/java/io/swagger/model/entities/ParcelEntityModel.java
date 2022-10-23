package io.swagger.model.entities;


import io.swagger.services.dto.Recipient;
import lombok.*;

import javax.persistence.*;

@Entity(name = "parcel")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode (exclude ={ "recipient","sender"})

public class ParcelEntityModel {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Float weight;

    @Column
    @OneToOne
    @JoinColumn(name = "recipient")//
    private Recipient recipient;

    @Column
    @OneToOne
    @JoinColumn(name = "sender")
    private Recipient sender;


}

