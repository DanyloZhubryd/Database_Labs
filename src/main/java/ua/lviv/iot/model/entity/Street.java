package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "street")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Street {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;


    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return id != null && Objects.equals(id, street.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
