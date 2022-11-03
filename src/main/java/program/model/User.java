package program.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Používateľ systému
 */
@Entity
@Table(name = "User")
@Getter
@Setter
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

    //TODO: prepojiť s tabuľkou appliance - id, názov, cena, a prepojenie kde budú zapísané všetky spotrebiče užívateľa a počet.
    //TODO: pridať tabuľku article - Titulok, text, obrázok???, dátum spravenia, autor, kategória, zobrazenie
    //TODO: page - Názov, text
}
