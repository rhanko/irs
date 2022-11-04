package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Rezervácia / objednávka miestnosti (izbu)
 * za dané obdobie môže mať 1 užívateľ rezerváciu / obsadenie len 1 miestnosť (izbu)
 */
@Entity
@Table(name = "Room_Order")
@Getter
@Setter
@NoArgsConstructor
public class RoomOrder {

    /**
     * Primárny kľúč id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    /**
     * Čas odkedy je rezervovaná / obsadená užívateľom
     */
    @Column(name = "time_since", columnDefinition = "Date", nullable = false)
    private Date timeSince;

    /**
     * Čas dokedy je rezervovaná / obsadená užívateľom
     */
    @Column(name = "time_until", columnDefinition = "Date", nullable = false)
    private Date timeUntil;

    /**
     * Užívateľ, ktorý vytvoril rezerváciu / obsadenie danej miestnosti (izby)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Miestnosť (Izba), ktorú si užívateľ rezervoval / obsadil
     * zabral iba 1 miesto kapacity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}
