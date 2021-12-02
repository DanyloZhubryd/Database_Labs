package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Position {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Float salary;

    //refernces

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Worker> workers;

    @ManyToMany(mappedBy = "positions")
    @ToString.Exclude
    private Set<Kindergarden> kindergardens;


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
