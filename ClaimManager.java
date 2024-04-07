
/**
 * @author <Nguyen Minh Quan - s3975128>
 */


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ClaimManager implements ClaimProcessManager {
    FileAccess fileAccess = new FileAccess();
    FileModifier fileModifier = new FileModifier();

    public ClaimManager() {
    }

    public void addClaim() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String id = this.generateId();
        System.out.println("-- ADDING NEW CLAIM --");
        System.out.println("Enter claim date (yyyy-MM-dd):");
        Date claimDate = new Date(scanner.nextLine());
        System.out.println("Enter insured person:");
        String insuredPerson = scanner.nextLine();
        System.out.println("Enter card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter exam date (dd-MM-yyyy):");
        Date examDate = new Date(scanner.nextLine());
        System.out.println("Enter claim amount:");
        double claimAmount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter claim status (New/Processing/Done):");
        String status = scanner.nextLine();
        System.out.println("Enter receiver bank:");
        String receiverBank = scanner.nextLine();
        System.out.println("Enter receiver name:");
        String receiverName = scanner.nextLine();
        System.out.println("Enter receiver number:");
        String receiverNumber = scanner.nextLine();
        List<String> documents = new ArrayList();
        System.out.println("Enter the number of documents:");
        int numDocuments = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < numDocuments; ++i) {
            System.out.println("Enter document name " + (i + 1) + ":");
            String documentName = scanner.nextLine();
            documents.add(documentName);
        }

        this.fileModifier.addClaim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBank, receiverName, receiverNumber);
    }

    public String generateId() throws IOException {
        Objects.requireNonNull(this.fileAccess);

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("claim.txt", "rw")) {
            String line;
            String id = null;

            // Read each line from the file
            while ((line = randomAccessFile.readLine()) != null) {
                String[] token = line.split(",");
                if (token.length > 0) {
                    id = token[0]; // Assuming the ID is the first token in each line
                }
            }

            if (id == null) {
                return "F000000000001"; // Start with the first ID if no existing IDs found
            } else {
                String numberString = id.substring(1);
                long afterIdScan = Long.parseLong(numberString);
                return String.format("F%012d", 1 + afterIdScan); // Increment ID by 1 and format
            }
        }
    }

    // Other methods in your ClaimManager class

    public static void main(String[] args) {
        ClaimManager manager = new ClaimManager();
        try {
            String generatedId = manager.generateId();
            System.out.println("Generated ID: " + generatedId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClaim(String id) {
        this.fileModifier.updateClaim(id);
    }

    public void deleteClaim(String id) {
        this.fileModifier.deleteClaim(id);
    }

    public void getClaimById(String claimId) {
        this.fileModifier.getClaimById(claimId);
    }

    public void getAllClaims() {
        this.fileModifier.getAllClaims();
    }
}
