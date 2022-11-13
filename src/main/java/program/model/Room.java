package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Miestnosť na bloku
 */
@Entity
@Table(name = "Room")
@Getter
@Setter
@NoArgsConstructor
public class Room {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Číslo miestnosti
     * kde prvé číslo označuje poschodie
     * a ďalšie dvojčíslie označuje číslo miestnosti na poschodí
     */
    @Column(name = "number", columnDefinition = "int", nullable = false)
    private int number;

    /**
     * Kapacita miestnosti
     */
    @Column(name = "capacity", columnDefinition = "tinyint")
    private byte capacity;

    /**
     * Veľkosť miestnosti
     * v metroch štvorcových
     */
    @Column(name = "size", columnDefinition = "int")
    private int size;

    /**
     * Blok, pod ktorý miestnosť patrí
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    /**
     * Typ izby
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;

    /**
     * Zoznam vybavenia izby
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private Set<RoomEquipment> roomEquipments = new HashSet<>();

    /**
     * Zoznam objednávok izby
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.REMOVE)
    private Set<RoomOrder> roomOrders = new HashSet<>();
}
