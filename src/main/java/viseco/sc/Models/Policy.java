package viseco.sc.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kamran on 9/8/2018.
 */
@Entity
@Document(collection = "POLICY")
public class Policy {

    @Id
    String id;
    String name;
    String priroty;
    String runningApplication;

    public Policy(String id, String name, String priroty, String runningApplication) {
        this.id = id;
        this.name = name;
        this.priroty = priroty;
        this.runningApplication = runningApplication;
    }
    public Policy(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriroty() {
        return priroty;
    }

    public void setPriroty(String priroty) {
        this.priroty = priroty;
    }

    public String getRunningApplication() {
        return runningApplication;
    }

    public void setRunningApplication(String runningApplication) {
        this.runningApplication = runningApplication;
    }
}
