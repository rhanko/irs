package program.model;

import javax.persistence.*;

@Entity
@Table(name = "Room_Equipment")
public class RoomEquipment {
//TODO: Prerobiť aby primarne kluce boli room a equipment nie id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @Column(name = "amount", columnDefinition = "int", nullable = false)
    private int amount;
}