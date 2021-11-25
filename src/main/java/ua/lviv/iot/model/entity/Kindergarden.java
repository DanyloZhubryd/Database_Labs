package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kindergarden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "address_id", nullable = false)
    private Integer addressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kindergarden that = (Kindergarden) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
