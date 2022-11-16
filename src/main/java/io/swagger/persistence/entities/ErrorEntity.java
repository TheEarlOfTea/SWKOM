package io.swagger.persistence.entities;


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

public class ErrorEntity extends AbstractEntity{

    @Column
    @NotNull
    private String errorMessage;

}
