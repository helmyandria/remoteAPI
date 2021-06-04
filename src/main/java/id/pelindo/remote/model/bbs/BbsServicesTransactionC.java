package id.pelindo.remote.model.bbs;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import java.io.Serializable;

public class BbsServicesTransactionC implements Serializable {

    @Id
    @JsonProperty("ID")
    private String id;
    @JsonProperty("DESCRIPTION")
    private String description;
    @JsonProperty("PERCENTAGE")
    private String percentage;
    @JsonProperty("BRANCH_ID")
    private String branch_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
}
