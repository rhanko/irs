package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Rola, respektíve stupeň právomoci.
 * napr. správca, domovníčka, študent, hosť, ...
 */
@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov role
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Zoznam užívateľov danej role
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
