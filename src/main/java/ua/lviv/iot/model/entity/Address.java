package ua.lviv.iot.model.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number", nullable = false)
    private String number;

    //foreign keys

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id", nullable = false)
    private Street street;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id", nullable = false)
    private District district;

    //references

    @OneToOne(mappedBy = "address")
    private Kindergarden kindergarden;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street=" + street +
                ", district=" + district +
                '}';
    }
}
