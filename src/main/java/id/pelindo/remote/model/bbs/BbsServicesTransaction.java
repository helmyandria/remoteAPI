package id.pelindo.remote.model.bbs;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import java.io.Serializable;

public class BbsServicesTransaction implements Serializable {

    @Id
    @JsonProperty("ID")
    private String id;
    @JsonProperty("INSTALLATION_TYPE")
    private String installation_type;
    @JsonProperty("PROFIT_CENTER")
    private String profit_center;
    @JsonProperty("CUSTOMER")
    private String customer;
    @JsonProperty("PERIOD")
    private String period;
    @JsonProperty("AMOUNT")
    private String amount;
    @JsonProperty("INSTALLATION_NUMBER")
    private String installation_number;
    @JsonProperty("BILLING_TYPE")
    private String billing_type;
    @JsonProperty("ID_INSTALASI")
    private String id_instalasi;
    @JsonProperty("GL_ACCOUNT")
    private String gl_account;
    @JsonProperty("BRANCH_ID")
    private String branch_id;
    @JsonProperty("INSTALLATION_CODE")
    private String installation_code;
    @JsonProperty("CUSTOMER_NAME")
    private String customer_name;
    @JsonProperty("CREATED_DATE")
    private String created_date;
    @JsonProperty("CREATED_BY")
    private String created_by;
    @JsonProperty("STATUS_DINAS")
    private String status_dinas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstallation_type() {
        return installation_type;
    }

    public void setInstallation_type(String installation_type) {
        this.installation_type = installation_type;
    }

    public String getProfit_center() {
        return profit_center;
    }

    public void setProfit_center(String profit_center) {
        this.profit_center = profit_center;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInstallation_number() {
        return installation_number;
    }

    public void setInstallation_number(String installation_number) {
        this.installation_number = installation_number;
    }

    public String getBilling_type() {
        return billing_type;
    }

    public void setBilling_type(String billing_type) {
        this.billing_type = billing_type;
    }

    public String getId_instalasi() {
        return id_instalasi;
    }

    public void setId_instalasi(String id_instalasi) {
        this.id_instalasi = id_instalasi;
    }

    public String getGl_account() {
        return gl_account;
    }

    public void setGl_account(String gl_account) {
        this.gl_account = gl_account;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getInstallation_code() {
        return installation_code;
    }

    public void setInstallation_code(String installation_code) {
        this.installation_code = installation_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getStatus_dinas() {
        return status_dinas;
    }

    public void setStatus_dinas(String status_dinas) {
        this.status_dinas = status_dinas;
    }
}
