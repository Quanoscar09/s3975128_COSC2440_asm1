/**
 * @author <Nguyen Minh Quan - s3975128>
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileModifier {
    FileAccess fileAccess = new FileAccess();
    List<Claim> claimList = new ArrayList();

    public FileModifier() {
    }

    public void addClaim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status, String receiverBank, String receiverName, String receiverNumber) {
        try {
            Objects.requireNonNull(this.fileAccess);
            RandomAccessFile raf = new RandomAccessFile("claim.txt", "rw");
            raf.seek(raf.length());
            Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBank, receiverName, receiverNumber);
            String var10000 = claim.getId();
            String data = var10000 + "," + String.valueOf(claim) + "," + claim.getInsuredPerson() + "," + Integer.parseInt(claim.getCardNumber()) + "," + String.valueOf(claim.getDocuments()) + "," + claim.getClaimAmount() + claim.getStatus() + "," + claim.getReceiverBank() + "," + claim.getReceiverName() + "," + claim.getReceiverNumber();
            raf.writeBytes(data + System.getProperty("line.separator"));
            raf.close();
        } catch (IOException var16) {
            throw new RuntimeException(var16);
        }
    }

    public void updateClaim(String idCheck) {
        Scanner scanner = new Scanner(System.in);

        try {
            Objects.requireNonNull(this.fileAccess);
            File inputFile = new File("claim.txt");
            File tempFile = new File("temp.txt");
            Objects.requireNonNull(this.fileAccess);
            BufferedReader reader = new BufferedReader(new FileReader("claim.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            while(true) {
                String currentLine;
                while((currentLine = reader.readLine()) != null) {
                    String[] token = currentLine.split(",");
                    String id = token[0].trim();
                    String date = token[1].trim();
                    String insuredPerson = token[2].trim();
                    String cardNumber = token[3].trim();
                    String examDateString = token[4].trim();
                    List<String> documents = new ArrayList();

                    for(int i = 5; i < token.length - 6; ++i) {
                        documents.add(token[i].trim());
                    }

                    double claimAmount = Double.parseDouble(token[token.length - 6].trim());
                    String status = token[token.length - 5].trim();
                    String receiverBank = token[token.length - 4].trim();
                    String receiverName = token[token.length - 3].trim();
                    String receiverNumber = token[token.length - 2].trim();
                    if (idCheck.equals(id)) {
                        System.out.println("--UPDATE CLAIM INFORMATION--");
                        System.out.println("Enter new claim's insured person: ");
                        String newInsuredPerson = scanner.next();
                        System.out.println("Enter new claim's card number: '");
                        String newCardNumber = scanner.next();
                        String insuredPersonReplace = insuredPerson.replace(insuredPerson, newInsuredPerson);
                        String newCardNumberReplace = cardNumber.replace(cardNumber, newCardNumber);
                        writer.write(id + "," + date + "," + insuredPersonReplace + "," + newCardNumberReplace + "," + examDateString + ",");
                        Iterator var25 = documents.iterator();

                        while(var25.hasNext()) {
                            String document = (String)var25.next();
                            writer.write(document + ";");
                        }

                        writer.write("," + claimAmount + "," + status + "," + receiverBank + "," + receiverName + "," + receiverNumber);
                    } else {
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }

                writer.close();
                reader.close();
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                }
                break;
            }
        } catch (IOException var27) {
            var27.printStackTrace();
        }

    }

    public void getClaimList() {
        Objects.requireNonNull(this.fileAccess);
        String fileName = "claim.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String[] token = currentLine.split(",");
                String id = token[0].trim();
                String claimDateStr = token[1].trim();
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date claimDate = formatter1.parse(claimDateStr);
                String insuredPerson = token[2].trim();
                String cardNumber = token[3].trim();
                String examDateStr = token[4].trim();
                Date examDate = formatter1.parse(examDateStr);
                List<String> documents = new ArrayList();

                for(int i = 5; i < token.length - 6; ++i) {
                    documents.add(token[i].trim());
                }

                double claimAmount = Double.parseDouble(token[token.length - 6].trim());
                String status = token[token.length - 5].trim();
                String receiverBank = token[token.length - 4].trim();
                String receiverName = token[token.length - 3].trim();
                String receiverNumber = token[token.length - 2].trim();
                this.claimList.add(new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, status, receiverBank, receiverName, receiverNumber));
            }

            reader.close();
        } catch (IOException var20) {
            var20.printStackTrace();
        } catch (ParseException var21) {
            throw new RuntimeException(var21);
        }

    }

    public void deleteClaim(String id) {
        Objects.requireNonNull(this.fileAccess);
        String fileName = "claim.txt";
        this.getClaimList();

        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp1.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String lineToRemove = null;
            Iterator var9 = this.claimList.iterator();

            while(var9.hasNext()) {
                Claim check = (Claim)var9.next();
                if (check.getId().equals(id)) {
                    lineToRemove = check.getId();
                    System.out.println(lineToRemove);
                }
            }

            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String[] token = currentLine.split(",");
                String idDelete = token[0].trim();
                if (!idDelete.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }
        } catch (IOException var11) {
            var11.printStackTrace();
        }

        System.out.println("Successfully deleted");
    }

    public void getClaimById(String id) {
        this.getClaimList();
        Iterator var2 = this.claimList.iterator();

        while(var2.hasNext()) {
            Claim claim = (Claim)var2.next();
            if (claim.getId().equals(id)) {
                System.out.println(claim);
            }
        }

    }

    public void getAllClaims() {
        this.getClaimList();
        Iterator var1 = this.claimList.iterator();

        while(var1.hasNext()) {
            Claim claim = (Claim)var1.next();
            System.out.println(claim);
            System.out.println("--------------------------------");
        }

    }
}
