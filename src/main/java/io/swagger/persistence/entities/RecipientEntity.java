package io.swagger.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_recipients")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter

public class RecipientEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String postalCode;
    @Column
    private String city;
    @Column
    private String country;

}
