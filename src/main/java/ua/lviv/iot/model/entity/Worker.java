package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "worker")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Worker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "passport", nullable = false)
    private String passport;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "fire_date")
    private LocalDate fireDate;

    @Column(name = "kindergarden_id")
    private Integer kindergardenId;

    @Column(name = "position_id")
    private Integer positionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id != null && Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
