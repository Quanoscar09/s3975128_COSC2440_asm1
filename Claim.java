/**
 * @author <Nguyen Minh Quan - s3975128>
 */


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;

    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private String status;
    private String receiverBank;
    private String receiverName;
    private String receiverNumber;

    private List<Claim> claimList = new ArrayList<Claim>();

    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, String status,
                 String receiverBank, String receiverName, String receiverNumber) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = new ArrayList<>(documents);
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBank = receiverBank;
        this.receiverName = receiverName;
        this.receiverNumber = receiverNumber;
        this.claimList = null;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(String receiverBank) {
        this.receiverBank = receiverBank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson='" + insuredPerson + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                ", receiverBank='" + receiverBank + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverNumber='" + receiverNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return Objects.equals(id, claim.id) && Objects.equals(claimDate, claim.claimDate) && Objects.equals(insuredPerson, claim.insuredPerson) && Objects.equals(cardNumber, claim.cardNumber) && Objects.equals(documents, claim.documents) && Objects.equals(claimAmount, claim.claimAmount) && Objects.equals(status, claim.status) && Objects.equals(receiverBank, claim.receiverBank) && Objects.equals(receiverName, claim.receiverName) && Objects.equals(receiverNumber, claim.receiverNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, claimDate, insuredPerson, cardNumber, documents, claimAmount, status, receiverBank, receiverName, receiverNumber);
    }
}
