package id.pelindo.remote.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prop_services_transaction")
public class ServicesTransaction implements Serializable {

    @Id
    private String id;
    private String installation_type;
    private String profit_center;
    private String customer;
    private String period;
    private String amount;
    private String installation_number;
    private String billing_type;
    private String id_instalasi;
    private String gl_account;
    private String branch_id;
    private String installation_code;
    private String customer_name;
    private String created_date;
    private String created_by;
    private String status_dinas;

//    @OneToMany(targetEntity = ServicesTransactionC.class, mappedBy="college", cascade = CascadeType.ALL)
//    @OneToMany
//    @JoinColumn(name="services_transaction_id", referencedColumnName = "id")
//    private List<ServicesTransactionC> servicesTransactionCs;

//    Work
    @JsonProperty("service_transaction")
    @OneToMany(mappedBy="service", orphanRemoval = true)
    private List<ServicesTransactionC> servicestransactioncs= new ArrayList<>();

//    tes
//    @OneToMany(mappedBy="servicestransactionc",fetch=FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true )
//    private List<ServicesTransactionC> servicestransactioncs = new ArrayList<ServicesTransactionC>();
//
    public List<ServicesTransactionC> getServicestransactioncs() {
        return servicestransactioncs;
    }

    public void setServicestransactioncs(List<ServicesTransactionC> servicestransactioncs) {
        this.servicestransactioncs = servicestransactioncs;
    }
//    tes

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

    public String getId_instalasi() {
        return id_instalasi;
    }

    public void setId_instalasi(String id_instalasi) {
        this.id_instalasi = id_instalasi;
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
