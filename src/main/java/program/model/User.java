package program.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Používateľ systému
 */
@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 20, message = "Musí obsahovať aspoň 4 znaky a najviac 20 znakov")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Môže obsahovať len znaky: a-z, A-Z, 0-9")
    @Column(name = "username", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String username;

    /**
     * Heslo užívateľa - prihlasovací údaj
     */
    @NotNull
    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Meno užívateľa
     */
    @Nullable
    @Pattern(regexp = "^$|^[a-zA-Z]+$", message = "Môže obsahovať len znaky: a-z, A-Z")
    @Column(name = "name", columnDefinition = "VARCHAR(20)")
    private String firstname;

    /**
     * Priezvisko užívateľa
     */
    @Nullable
    @Pattern(regexp = "^(?:[a-zA-Z]+)|$", message = "Môže obsahovať len znaky: a-z, A-Z")
    @Column(name = "surname", columnDefinition = "VARCHAR(20)")
    private String surname;

    @Email
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30, message = "Môže obsahovať najviac 30 znakov")
    @Pattern(regexp = "^[a-zA-Z0-9@._]+$", message = "Môže obsahovať len znaky: a-z, A-Z, 0-9, @ a .")
    @Column(name = "mail", columnDefinition = "VARCHAR(30)", nullable = false)
    private String mail;

    /**
     * Zoznam rolí, ktoré má užívateľ
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private List<Role> role = new ArrayList<>();

    /**
     * Fakulta, ktorú navštevuje užívateľ (ak je študent)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    /**
     * Zoznam spotrebičov užívateľa
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<UserAppliance> userAppliances = new HashSet<>();

    /**
     * Zoznam miestnosti (izieb), ktoré užívateľ obsadil / rezervoval
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<RoomOrder> roomOrders = new HashSet<>();


    /**
     * Zoznam článkov, ktoré napísal užívateľ
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Article> articles = new HashSet<>();

    public void addRole(Role role) {
        if (!this.role.contains(role)) {
            this.role.add(role);
        }
    }

    public void removeRole(Role role) {
        if (this.role.contains(role)) {
            this.role.remove(role);
        }
    }
}
