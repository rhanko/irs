package program.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Block")
public class Block {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov bloku
     */
    @Column(name = "name_block", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameBlock;

    /**
     * Počet poschodí na bloku.
     * Prízemie je 0 poschodie, prízemie sa neráta ako poschodie.
     */
    @Column(name = "floors", columnDefinition = "int", nullable = false)
    private int floors;

    /**
     * Ubytovacie zariadenie pod ktorú blok patrí
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id", nullable = false)
    private Dormitory dormitory;

    /**
     * Izby daného bloku
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "block")
    private List<Room> rooms;
}