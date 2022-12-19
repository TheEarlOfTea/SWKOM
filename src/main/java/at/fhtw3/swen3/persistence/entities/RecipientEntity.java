package at.fhtw3.swen3.persistence.entities;

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
    @Pattern(regexp = "^[A-Za-zß0-9 \\/-]*", message = "pattern must match ^[A-Za-zß0-9 \\/-]*")
    private String street;

    @Column
    @NotNull(message = "postalcode may not be null")
    private String postalCode;

    @Column
    @NotNull(message = "city may not be null")
    private String city;

    @Column
    @NotNull(message = "country may not be null")
    @Pattern(regexp = "[A-Za-z]*", message = "Country must match pattern [A-Za-z]*")
    private String country;

}
