package program.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Equipment")
@Getter
@Setter
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
    private Set<RoomEquipment> roomEquipment = new HashSet<>();
}
