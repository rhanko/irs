package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class RoomType {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov typu miestnosti
     */
    @Column(name = "name", columnDefinition = "VARCHAR(30)", nullable = false)
    private String name;

    /**
     * Popisok miestnosti
     */
    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String description;

    /**
     * Zoznam miestnosti daného typu
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType", cascade = CascadeType.REMOVE)
    private Set<Room> rooms = new HashSet<>();
}
