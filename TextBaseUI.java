/**
 * @author <Nguyen Minh Quan - s3975128>
 */


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextBaseUI {
    private final ClaimManager system = new ClaimManager();

    public TextBaseUI() {
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("=== Insurance Claim System ===");
            System.out.println("1. View All Claims");
            System.out.println("2. Add a Claim");
            System.out.println("3. Delete Claim");
            System.out.println("4. Update Claim");
            System.out.println("5. Get Claim by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        this.system.getAllClaims();
                        break;
                    case 2:
                        this.system.addClaim();
                        break;
                    case 3:
                        System.out.println("-- DELETING CLAIM --");
                        System.out.print("- Please enter the ID you want to delete: ");
                        String idDelete = scanner.next();
                        this.system.deleteClaim(idDelete);
                        break;
                    case 4:
                        System.out.println("-- UPDATING CLAIM --");
                        System.out.print("- Please enter the ID you want to update: ");
                        String idUpdate = scanner.next();
                        this.system.updateClaim(idUpdate);
                        break;
                    case 5:
                        System.out.println("-- GETTING CLAIM --");
                        System.out.print("- Please enter the claim ID you want to get: ");
                        String idClaim = scanner.next();
                        this.system.getClaimById(idClaim);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException var6) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                choice = -1;
            } catch (IOException var7) {
                System.out.println("An error occurred: " + var7.getMessage());
            }
        } while(choice != 6);

        scanner.close();
    }

    public static void main(String[] args) {
        TextBaseUI ui = new TextBaseUI();
        ui.run();
    }
}
