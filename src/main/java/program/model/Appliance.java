package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Spotrebiče
 */
@Entity
@Table(name = "Appliance")
@Getter
@Setter
@NoArgsConstructor
public class Appliance {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Názov spotrebiča
     */
    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    /**
     * Mesačná suma za spotrebič
     */
    @Column(name = "price", columnDefinition = "int", nullable = false)
    private int price;

    /**
     * Zoznam užívateľov spotrebiča
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appliance", cascade = CascadeType.REMOVE)
    private Set<UserAppliance> userAppliances = new HashSet<>();
}
