package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Vybavenie
 */
@Entity
@Table(name = "Equipment")
@Getter
@Setter
@NoArgsConstructor
public class Equipment {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov vybavenia
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Popisok vybavenia
     */
    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String description;

    /**
     * Zoznam izieb vybavenia
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment", cascade = CascadeType.REMOVE)
    private Set<RoomEquipment> roomEquipment = new HashSet<>();
}
