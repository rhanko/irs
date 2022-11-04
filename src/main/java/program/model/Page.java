package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Stránka
 */
@Entity
@Table(name = "Page")
@Getter
@Setter
@NoArgsConstructor
public class Page {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Titulok stránky / názov stránky
     */
    @Column(name = "title", columnDefinition = "VARCHAR(30)", nullable = false)
    private String title;

    /**
     * Obsah stránky
     */
    //TODO: mozno spravit doc
    @Column(name = "text", columnDefinition = "MediumText")
    private String text;


}
