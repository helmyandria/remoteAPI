package id.pelindo.remote.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prop_services_transaction_c")
public class ServicesTransactionC implements Serializable {

    @Id
    @GeneratedValue
    private String id;
    private String description;
    private String percentage;
    //    private String services_transaction_id;
    private String branch_id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "services_transaction_id", nullable = false)
//    private ServicesTransaction servicesTransaction;

//    work
//    @ManyToOne
//    @JoinColumn(name="services_transaction_id")

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "services_transaction_id")
    private ServicesTransaction service;

    //    tes
//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private ServicesTransaction servicesTransaction;
//
    public void setServicesTransaction(ServicesTransaction servicesTransaction) {
        this.service = servicesTransaction;
    }
//
//    public ServicesTransaction getServicesTransaction() {
//        return servicesTransaction;
//    }
//    tes

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

//    public String getServices_transaction_id() {
//        return services_transaction_id;
//    }
//
//    public void setServices_transaction_id(String services_transaction_id) {
//        this.services_transaction_id = services_transaction_id;
//    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }
}
