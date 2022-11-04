package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Používateľ systému
 */
@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Užívateľské meno - prihlasovací údaj
     */
    @Column(name = "username", columnDefinition = "VARCHAR(20)", nullable = false)
    private String username;

    /**
     * Heslo užívateľa - prihlasovací údaj
     */
    @Column(name = "password", columnDefinition = "VARCHAR(20)", nullable = false)
    private String password;

    /**
     * Meno užívateľa
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)")
    private String name;

    /**
     * Priezvisko užívateľa
     */
    @Column(name = "surname", columnDefinition = "VARCHAR(20)")
    private String surname;

    /**
     * Rola, ktorú má užívateľ
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    /**
     * Fakulta, ktorú navštevuje užívateľ (ak je študent)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    /**
     * Zoznam spotrebičov užívateľa
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserAppliance> userAppliances = new HashSet<>();

    /**
     * Zoznam miestnosti (izieb), ktoré užívateľ obsadil / rezervoval
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<RoomOrder> roomOrders = new HashSet<>();


    /**
     * Zoznam článkov, ktoré napísal užívateľ
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Article> articles = new HashSet<>();

    //TODO: page - Názov, text
}
