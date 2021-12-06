package ua.lviv.iot.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "child")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Child {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "birth_certificate", nullable = false)
    private String birthCertificate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    //foreign keys

    @ManyToOne
    @JoinColumn(name = "child_group_id", nullable = false)
    private ChildGroup childGroup;

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", birthCertificate='" + birthCertificate + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", childGroup=" + childGroup +
                '}';
    }
}
