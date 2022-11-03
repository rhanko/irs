package program.model;

import javax.persistence.*;
import java.util.List;

/**
 * Univerzita
 */
@Entity
@Table(name = "University")
public class University {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov univerzity
     */
    @Column(name = "name_university", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameUniversity;

    /**
     * Fakulty danej univerzity
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
    private List<Faculty> faculties;
}
