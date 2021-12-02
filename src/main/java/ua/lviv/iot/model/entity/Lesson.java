package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Lesson {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "classroom", nullable = false)
    private Integer classroom;

    @Column(name = "lesson_day", nullable = false)
    private String lessonDay;

    @Column(name = "lesson__time", nullable = false)
    private LocalTime lessonTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id != null && Objects.equals(id, lesson.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
