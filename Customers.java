

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customers {
    private String id;
    private String fullName;
    private String insuranceCard;
    private List<Claim> claims;

    public Customers(String id, String fullName, String insuranceCard) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard='" + insuranceCard + '\'' +
                ", claims=" + claims +
                '}';
    }
}