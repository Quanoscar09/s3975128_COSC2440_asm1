import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ClaimProcessManager {

    // Add a claim to the manager
    void addClaim(Claim claim) throws IOException;

    // Update an existing claim in the manager
    void updateClaim(Claim claim);

    // Delete a claim from the manager
    void deleteClaim(String claimId);

    // Get a single claim from the manager by its ID
    Claim getClaimById(String claimId);

    // Get all claims managed by the manager
    List<Claim> getAllClaims();
    Claim getOne (String claimId) ;


}
