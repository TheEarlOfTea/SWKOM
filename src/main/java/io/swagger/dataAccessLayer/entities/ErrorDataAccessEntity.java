package io.swagger.dataAccessLayer.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "error")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode



public class ErrorDataAccessEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @Column
    private String errorMessage;

}
