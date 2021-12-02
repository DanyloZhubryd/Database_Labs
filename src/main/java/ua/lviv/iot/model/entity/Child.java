package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "child")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Child {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "birth_certificate", nullable = false)
    private String birthCertificate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "child_group", nullable = false)
    private Integer childGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return birthCertificate != null && Objects.equals(birthCertificate, child.birthCertificate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
