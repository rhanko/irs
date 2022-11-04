package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Fakulta školy, univerzity
 */
@Entity
@Table(name = "Faculty")
@Getter
@Setter
@NoArgsConstructor
public class Faculty {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov fakulty
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Univerzita/ škola pod ktorú fakulta patrí
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    /**
     * Zoznam užívateľov navštevujúcich fakultu
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private Set<User> users = new HashSet<>();

}