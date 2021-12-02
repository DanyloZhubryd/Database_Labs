package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "kindergarden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Kindergarden {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flats_count", nullable = false)
    private Integer flatsCount;

    @Column(name = "workers_count")
    private Integer workersCount;

    @Column(name = "group_count")
    private Integer groupCount;

    //foreign keys

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    //references

    @OneToMany(mappedBy = "kindergarden", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Worker> workers;

    @OneToMany(mappedBy = "kindergarden", fetch = FetchType.LAZY)
    @ToString.Exclude
    private  Collection<ChildGroup> childGroups;

    @ManyToMany
    @JoinTable(name = "kindergarden_has_position",
    joinColumns = @JoinColumn(name = "kindergarden_id"),
    inverseJoinColumns = @JoinColumn(name = "position_id"))
    @ToString.Exclude
    private Set<Position> positions;


    @Override
    public String toString() {
        return "Kindergarden{" +
                "id=" + id +
                ", flatsCount=" + flatsCount +
                ", workersCount=" + workersCount +
                ", groupCount=" + groupCount +
                ", address=" + address +
                '}';
    }
}
