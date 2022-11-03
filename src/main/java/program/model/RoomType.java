package program.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Typ miestnosti
 * napr. študentská izba, sprcha, toalety, ...
 */
@Entity
@Table(name = "RoomType")
@Getter
@Setter
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
    private Set<Room> rooms = new HashSet<>();
}
