/**
 * @author <Nguyen Minh Quan - s3975128>
 */

class Dependent extends Customers {
    private String id;
    private String fullName;
    private String insuranceCard;

    public Dependent(String id, String fullName, String insuranceCard) {
        super(id, fullName, insuranceCard);
    }
}