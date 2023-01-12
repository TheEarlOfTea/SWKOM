package at.fhtw.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="t_hops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class HopEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @NotNull(message= "hopType may not be null")
    private String hopType;

    @Column
    @NotNull(message = "code may not be null")
    private String code;

    @Column
    private String description;

    @Column
    @NotNull(message= "processingDelayMins may not be null")
    @Min(value = 1, message = "processingDelayMins cannot be less than 1")
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @Column
    @NotNull(message= "locationCoordinates may not be null")
    private Point locationCoordinates;



}
