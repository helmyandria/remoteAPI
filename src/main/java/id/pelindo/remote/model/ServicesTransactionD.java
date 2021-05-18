package id.pelindo.remote.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "prop_services_transaction_d")
public class ServicesTransactionD implements Serializable {

    private String id;
    private String services_transaction_id;
    private String price_type;
    private String price_code;
    private String tariff;
    private String meter_from;
    private String meter_to;
    private String used;
    private String multiply;
    private String branch_id;
    private String installation_code;
    private String keterangan;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServices_transaction_id() {
        return services_transaction_id;
    }

    public void setServices_transaction_id(String services_transaction_id) {
        this.services_transaction_id = services_transaction_id;
    }

    public String getPrice_type() {
        return price_type;
    }

    public void setPrice_type(String price_type) {
        this.price_type = price_type;
    }

    public String getPrice_code() {
        return price_code;
    }

    public void setPrice_code(String price_code) {
        this.price_code = price_code;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getMeter_from() {
        return meter_from;
    }

    public void setMeter_from(String meter_from) {
        this.meter_from = meter_from;
    }

    public String getMeter_to() {
        return meter_to;
    }

    public void setMeter_to(String meter_to) {
        this.meter_to = meter_to;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getMultiply() {
        return multiply;
    }

    public void setMultiply(String multiply) {
        this.multiply = multiply;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
