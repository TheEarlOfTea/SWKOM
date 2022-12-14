package io.swagger.persistence.entities;

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
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$", message = "code has to match \'^[A-Z]{4}\\d{1,4}$\'")
    @NotNull(message = "code may not be null")
    private String code;

    @Column
    @NotNull(message= "description may not be null")
    @Pattern(regexp="^[A-Z0-9\\- ]*", message="description has to match \'^[A-Z0-9\\- ]*\'")
    private String description;

    @Column
    @NotNull(message= "processingDelayMins may not be null")
    @Min(value = 1, message = "processingDelayMins cannot be less than 1")
    private Integer processingDelayMins;

    @Column
    @Pattern(regexp="^[A-Z0-9\\- ]*", message="location has to match \'^[A-Z0-9\\- ]*\'")
    @NotNull(message= "locationName may not be null")
    private String locationName;

    @Column
    @NotNull(message= "locationCoordinates may not be null")
    private Point locationCoordinates;



}
