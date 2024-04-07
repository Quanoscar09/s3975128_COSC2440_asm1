/**
 * @author <Nguyen Minh Quan - s3975128>
 */
import java.io.IOException;

public interface ClaimProcessManager {

    // Add a claim to the manager
    void addClaim() throws IOException;

    // Update an existing claim in the manager
    void updateClaim(String Id);

    // Delete a claim from the manager
    void deleteClaim(String Id);

    // Get a single claim from the manager by its ID
    void getClaimById(String claimId);

    // Get all claims managed by the manager
    void getAllClaims();
}