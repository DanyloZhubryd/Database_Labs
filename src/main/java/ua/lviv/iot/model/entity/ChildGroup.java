package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "child_group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChildGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "bedroom_number")
    private Integer bedroomNumber;

    @Column(name = "kindergarden_id", nullable = false)
    private Integer kindergardenId;

    @Column(name = "worker_passport", nullable = false)
    private String workerPassport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildGroup that = (ChildGroup) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
