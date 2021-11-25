package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "district")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class District {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return id != null && Objects.equals(id, district.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
