package program.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Ubytovacie zariadenie
 */
@Entity
@Table(name = "Dortmitory")
@Getter
@Setter
@NoArgsConstructor
public class Dormitory {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov ubytovacieho zariadenia
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Zoznam blokov, ktoré patria pod dané ubytovacie zariadenie
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dormitory")
    private Set<Block> blocks = new HashSet<>();
}
