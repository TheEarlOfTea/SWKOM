package at.fhtw.swen3.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "t_hoparrivals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder


public class HopArrivalEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$", message = "has to match \'^[A-Z]{4}\\d{1,4}$\'")
    @NotNull(message = "code may not be null")
    private String code;

    @Column
    @NotNull(message= "description may not be null")
    private String description;

    @Column(name = "dateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "dateTime may not be null")
    private OffsetDateTime dateTime;
}
