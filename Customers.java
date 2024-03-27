/**
 * @author <Nguyen Minh Quan - s3975128>
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customers {
    private final String id;
    private final String fullName;
    private final String insuranceCard;
    private final List<Claim> claims;

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

        return Collections.unmodifiableList(claims);
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }
}
