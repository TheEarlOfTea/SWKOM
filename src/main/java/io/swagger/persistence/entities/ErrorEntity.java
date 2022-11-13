package io.swagger.persistence.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_errors")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class ErrorEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @Column
    @NotNull
    private String errorMessage;

}
