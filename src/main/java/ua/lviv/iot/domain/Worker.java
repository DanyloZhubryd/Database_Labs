package ua.lviv.iot.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "worker")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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
    private String hireDate;

    @Column(name = "fire_date")
    private String fireDate;

    //foreign keys
    @ManyToOne
    @JoinColumn(name = "kindergarden_id", referencedColumnName = "id")
    private Kindergarden kindergarden;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    //references

    @OneToOne(mappedBy = "worker")
    private ChildGroup childGroup;


    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", passport='" + passport + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", fireDate='" + fireDate + '\'' +
                ", kindergarden=" + kindergarden +
                ", position=" + position +
                ", childGroup=" + childGroup +
                '}';
    }
}
