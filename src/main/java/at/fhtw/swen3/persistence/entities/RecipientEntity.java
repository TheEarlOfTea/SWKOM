package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "t_recipients")
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter

public class RecipientEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;


    @Column
    @NotNull(message = "name may not be null")
    private String name;

    @Column
    private String street;

    @Column
    @NotNull(message = "postalcode may not be null")
    private String postalCode;

    @Column
    @NotNull(message = "city may not be null")
    private String city;

    @Column
    @NotNull(message = "country may not be null")
    private String country;

}
