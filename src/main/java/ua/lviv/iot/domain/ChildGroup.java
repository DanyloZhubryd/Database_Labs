package ua.lviv.iot.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "child_group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ChildGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "bedroom_number")
    private Integer bedroomNumber;

    //foreign keys

    @ManyToOne
    @JoinColumn(name = "kindergarden_id", referencedColumnName = "id", nullable = false)
    private Kindergarden kindergarden;

    @OneToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id", nullable = false)
    private Worker worker;

    //references

    @OneToMany(mappedBy = "childGroup", fetch = FetchType.LAZY)
    private Collection<Child> children;

    @ManyToMany
    @JoinTable(name = "schedule",
            joinColumns = @JoinColumn(name = "child_group_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    @ToString.Exclude
    private Set<Lesson> lessons;

    @Override
    public String toString() {
        return "ChildGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bedroomNumber=" + bedroomNumber +
                ", kindergarden=" + kindergarden +
                ", worker=" + worker +
                '}';
    }
}
