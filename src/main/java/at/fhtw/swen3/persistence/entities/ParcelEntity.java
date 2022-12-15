package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name="t_parcels")
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ParcelEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected long id;

    @Column
    @Pattern(regexp="^[A-Z0-9]{9}$", message = "has to match \'^[A-Z0-9]{9}$\'")
    @NotNull(message = "trackingId may not be null")
    private String trackingId;

    @Column
    @DecimalMin(value="0.001", message="parcels must weight at least 1 gram")
    private float weight;

    @ManyToOne
    @JoinColumn(name = "fk_recipients")
    @NotNull(message= "recipient cannot be null")
    private RecipientEntity recipient;

    @ManyToOne
    @JoinColumn(name = "fk_sender")
    @NotNull(message= "sender cannot be null")
    private RecipientEntity sender;

    @Column
    @NotNull(message="state may not be null")
    private TrackingInformation.StateEnum state;

    @ManyToMany(targetEntity = HopArrivalEntity.class)
    @JoinTable(name="t_visitedHops")
    @NotNull(message="visitedHops may not be null")
    private List<HopArrivalEntity> visitedHops;

    @ManyToMany(targetEntity = HopArrivalEntity.class)
    @JoinTable(name="t_futureHops")
    @NotNull(message="futureHops may not be null")
    private List<HopArrivalEntity> futureHops;
}
