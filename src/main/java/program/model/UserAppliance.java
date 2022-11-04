package program.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.modelID.UserApplianceID;

import javax.persistence.*;

/**
 * Spotrebiče užívateľa
 */
@Entity
@Table(name = "User_Appliance")
@Getter
@Setter
@NoArgsConstructor
public class UserAppliance {

    /**
     * Zložený primárny kľúč id
     */
    @EmbeddedId
    private UserApplianceID id = new UserApplianceID();

    /**
     * Užívateľ
     */
    @ManyToOne
    @MapsId("userid")
    private User user;

    /**
     * Spotrebič
     */
    @ManyToOne
    @MapsId("applianceid")
    private Appliance appliance;

    /**
     * Množstvo daného spotrebiča, ktoré si vzal užívateľ na izbu
     */
    @Column(name = "amount", columnDefinition = "int", nullable = false)
    private int amount;
}
