package program.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Equipment")
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
    private List<RoomEquipment> roomEquipment;
}
