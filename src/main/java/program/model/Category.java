package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Kategória, pod ktorú spadá článok
 */
@Entity
@Table(name = "Category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov kategórie
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Zoznam článkov, ktoré spadajú pod danú kategóriu
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    private Set<Article> articles = new HashSet<>();
}
