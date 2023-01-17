package program.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Článok
 */
@Entity
@Table(name = "Article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Titulok článku
     */
    @Column(name = "title", columnDefinition = "VARCHAR(25)", nullable = false)
    private String title;

    /**
     * Dátum vytvorenia
     */
    @Column(name = "date", columnDefinition = "Datetime", nullable = true)
    private LocalDateTime date;
    public String getDate() {
        return date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear() + " " + date.getHour() + ":" + date.getMinute() + ":" + date.getSecond();
    }

    /**
     * Zobrazenie
     * ak 1 = zobraziť
     * ak 0 = skryť
     */
    @Column(name = "is_shown", columnDefinition = "bit", nullable = false)
    private boolean isShown;

    /**
     * Užívateľ, ktorý zdielal článok
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Kategória, pod ktorú článok spadá
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * Text článku
     */
    @Column(name = "text", columnDefinition = "MediumText", nullable = false)
    private String text;
}
