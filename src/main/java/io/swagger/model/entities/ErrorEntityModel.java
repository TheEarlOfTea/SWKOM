package io.swagger.model.entities;


import lombok.*;

import javax.persistence.*;

@Entity(name = "error")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class ErrorEntityModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;

    @Column
    private String errorMessage;

}
