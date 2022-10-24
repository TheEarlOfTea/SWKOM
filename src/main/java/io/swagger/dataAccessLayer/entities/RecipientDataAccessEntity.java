package io.swagger.dataAccessLayer.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Recipient")
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class RecipientDataAccessEntity {
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
