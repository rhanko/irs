package program.modelID;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
public class RoomEquipmentID implements Serializable {
    private int roomid;
    private int equipmentid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomEquipmentID that)) return false;
        return getRoomid() == that.getRoomid() && getEquipmentid() == that.getEquipmentid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomid(), getEquipmentid());
    }
}
