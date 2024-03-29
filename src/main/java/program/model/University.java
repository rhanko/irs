package program.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Univerzita
 */
@Entity
@Table(name = "University")
@Getter
@Setter
@NoArgsConstructor
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
     * Zoznam fakúlt danej univerzity
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "university", cascade = CascadeType.REMOVE)
    private Set<Faculty> faculties = new HashSet<>();
}
