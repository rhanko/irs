package program.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Room")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "number", columnDefinition = "int", nullable = false)
    private int number;

    @Column(name = "capacity", columnDefinition = "tinyint", nullable = false)
    private byte capacity;

    @Column(name = "size", columnDefinition = "int")
    private int size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private Set<RoomEquipment> roomEquipment = new HashSet<>();
}
