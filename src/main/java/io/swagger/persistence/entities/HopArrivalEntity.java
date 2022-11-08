package io.swagger.persistence.entities;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import org.threeten.bp.OffsetDateTime;

@Entity
@Table(name = "t_hoparrivals")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor



public class HopArrivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column(name = "dateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
