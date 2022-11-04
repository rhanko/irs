package program.modelID;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class UserApplianceID implements Serializable {
    private int userid;
    private int applianceid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserApplianceID that)) return false;
        return getUserid() == that.getUserid() && getApplianceid() == that.getApplianceid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getApplianceid());
    }
}
