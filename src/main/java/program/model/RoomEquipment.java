package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.modelID.RoomEquipmentID;

import javax.persistence.*;

/**
 * Vybavenie miestnosti
 */
@Entity
@Table(name = "Room_Equipment")
@Getter
@Setter
@NoArgsConstructor
public class RoomEquipment {

    /**
     * Zložený primárny kľúč id
     */
    @EmbeddedId
    private RoomEquipmentID id = new RoomEquipmentID();

    /**
     * Miestnosť
     */
    @ManyToOne
    @MapsId("roomid")
    private Room room;

    /**
     * Vybavenie
     */
    @ManyToOne
    @MapsId("equipmentid")
    private Equipment equipment;

    /**
     * Množstvo daného vybavenia v miestnosti
     */
    @Column(name = "amount", columnDefinition = "int", nullable = false)
    private int amount;
}