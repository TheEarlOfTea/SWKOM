package at.fhtw3.swen3.persistence.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_errors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder

public class ErrorEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @NotNull
    private String errorMessage;

}
