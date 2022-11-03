package program.model;

import javax.persistence.*;

@Entity
@Table(name = "Appliance")
public class Appliance {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(name = "price", columnDefinition = "int", nullable = false)
    private int price;

    //TODO: prepojiť s User
}
