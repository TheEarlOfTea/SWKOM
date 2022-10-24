package io.swagger.dataAccessLayer.entities;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity(name = "HopArrival")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"visitedHops","futureHops"})
@EqualsAndHashCode(exclude = {"visitedHops","futureHops"})



public class HopArrivalDataAccessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
