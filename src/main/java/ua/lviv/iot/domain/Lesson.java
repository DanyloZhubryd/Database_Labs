package ua.lviv.iot.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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

    @Column(name = "lesson_time", nullable = false)
    private LocalTime lessonTime;

    //references

    @ManyToMany(mappedBy = "lessons")
    private Set<ChildGroup> childGroups;


    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classroom=" + classroom +
                ", lessonDay='" + lessonDay + '\'' +
                ", lessonTime='" + lessonTime + '\'' +
                '}';
    }
}

