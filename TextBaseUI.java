/**
 * @author <Nguyen Minh Quan - s3975128>
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TextBaseUI {
    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String INSURANCE_CARDS_FILE = "insuranceCard.txt";
    private static final String CLAIMS_FILE = "claim.txt";

    private static List<Customers> customers;
    private static List<InsuranceCard> insuranceCards;
    private static List<Claim> claims;

    public static void main(String[] args) {
        loadData(); // Load data from files

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Insurance Claim System ===");
            System.out.println("1. View All Claims");
            System.out.println("2. Add a Claim");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewAllClaims();
                    break;
                case 2:
                    addClaim(scanner);
                    break;
                case 3:
                    saveData(); // Save data to files before exiting
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
    }

    private static void loadData() {
        customers = readCustomersFromFile(CUSTOMERS_FILE);
        insuranceCards = readInsuranceCardsFromFile(INSURANCE_CARDS_FILE, customers);
        claims = readClaimsFromFile(insuranceCards);
    }

    private static List<Claim> readClaimsFromFile(List<InsuranceCard> insuranceCards) {
        return new ArrayList<>(); // Placeholder for reading claims from file
    }

    private static List<InsuranceCard> readInsuranceCardsFromFile(String insuranceCardsFile, List<Customers> customers) {
        return new ArrayList<>(); // Placeholder for reading insurance cards from file
    }

    private static List<Customers> readCustomersFromFile(String customersFile) {
        return new ArrayList<>(); // Placeholder for reading customers from file
    }

    private static void saveData() {
        saveCustomersToFile(customers, CUSTOMERS_FILE);
        saveInsuranceCardsToFile(insuranceCards, INSURANCE_CARDS_FILE);
        saveClaimsToFile(claims, CLAIMS_FILE);
    }

    private static void saveClaimsToFile(List<Claim> claims, String claimsFile) {
        // Placeholder for saving claims to file
    }

    private static void saveInsuranceCardsToFile(List<InsuranceCard> insuranceCards, String insuranceCardsFile) {
        // Placeholder for saving insurance cards to file
    }

    private static void saveCustomersToFile(List<Customers> customers, String customersFile) {
        // Placeholder for saving customers to file
    }

    private static void viewAllClaims() {
        if (claims.isEmpty()) {
            System.out.println("No claims available.");
        } else {
            System.out.println("All Claims:");
            for (Claim claim : claims) {
                System.out.println(claim);
            }
        }
    }

    private static void addClaim(Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter claim details:");

        System.out.print("Claim ID: ");
        String id = scanner.nextLine();

        System.out.print("Claim Date (yyyy-MM-dd): ");
        String claimDateString = scanner.nextLine();
        Date claimDate = parseDate(claimDateString);

        System.out.print("Insured Person: ");
        String insuredPerson = scanner.nextLine();

        System.out.print("Card Number: ");
        String cardNumber = scanner.nextLine();

        System.out.print("Exam Date (yyyy-MM-dd): ");
        String examDateString = scanner.nextLine();
        Date examDate = parseDate(examDateString);

        System.out.print("Claim Amount: ");
        double claimAmount = scanner.nextDouble();

        System.out.print("Status: ");
        String status = scanner.next();

        // Add the claim to the list
        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, new ArrayList<>(), claimAmount, status, null);
        claims.add(claim);
        System.out.println("Claim added successfully.");
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            return null;
        }
    }

    public void addClaim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status, String receiverBank, String receiverName, String receiverNumber) {
    }

    private static class InsuranceCard {
    }

    private static class Customers {
    }

    private static class Claim {
        private String id;
        private Date claimDate;
        private String insuredPerson;
        private String cardNumber;
        private Date examDate;
        private List<?> list;
        private double claimAmount;
        private String status;
        private Object object;

        public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<?> list, double claimAmount, String status, Object object) {
            this.id = id;
            this.claimDate = claimDate;
            this.insuredPerson = insuredPerson;
            this.cardNumber = cardNumber;
            this.examDate = examDate;
            this.list = list;
            this.claimAmount = claimAmount;
            this.status = status;
            this.object = object;
        }

        @Override
        public String toString() {
            return "Claim{" +
                    "id='" + id + '\'' +
                    ", claimDate=" + claimDate +
                    ", insuredPerson='" + insuredPerson + '\'' +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", examDate=" + examDate +
                    ", list=" + list +
                    ", claimAmount=" + claimAmount +
                    ", status='" + status + '\'' +
                    ", object=" + object +
                    '}';
        }
    }
}


