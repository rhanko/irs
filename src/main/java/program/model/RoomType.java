package program.model;

import javax.persistence.*;
import java.util.List;

/**
 * Typ miestnosti
 * napr. študentská izba, sprcha, toalety, ...
 */
@Entity
@Table(name = "RoomType")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "name_type", columnDefinition = "VARCHAR(30)", nullable = false)
    private String nameType;

    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String capacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType")
    private List<Room> rooms;
}
