package io.swagger.model.entities;


import lombok.*;

import javax.persistence.*;

@Entity(name = "NewParcelInfo")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class NewParcelInfoEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private long id;
    @Column
    private String trackingId;


}
