package program.model;

import javax.persistence.*;
import java.util.List;

/**
 * Rola, respektíve stupeň právomoci.
 * napr. správca, domovníčka, študent, hosť, ...
 */
@Entity
@Table(name = "Role")
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
    @Column(name = "name_role", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameRole;

    /**
     * Úžívatelia danej role
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;
}
