package program.model;

import javax.persistence.*;
import java.util.List;

/**
 * Fakulta školy, univerzity
 */
@Entity
@Table(name = "Faculty")
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
    @Column(name = "name_faculty", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameFaculty;

    /**
     * Univerzita/ škola pod ktorú fakulta patrí
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    /**
     * Užívatelia danej fakulty
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private List<User> users;

}