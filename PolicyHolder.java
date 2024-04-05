/**
 * @author <Nguyen Minh Quan - s3975128>
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PolicyHolder extends Customers {
    private List<Dependent> dependents;

    public PolicyHolder(String id, String fullName, String insuranceCard) {
        super(id, fullName, insuranceCard); // Call constructor of superclass
        this.dependents = new ArrayList<>();
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }

    public void removeDependent(Dependent dependent) {
        dependents.remove(dependent);
    }
}
