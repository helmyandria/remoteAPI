package id.pelindo.remote.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "mobile_akun")
@EntityListeners(AuditingEntityListener.class)
public class Akun {

    private String username;
    private String password;
    private String role;
    private String id;
    private String customer_id;
    private String customer_name;
    private String installation_code;
    private String installation_address;
    private String installation_type;
    private String power_capacity;
    private String branch_id;
    private String profit_center;
    private String installation_number;
    private String multiply_fact;

    private String minimum_used;
    private String biaya_admin;
    private String biaya_beban;
    private String minimum_payment;

    public Akun() {
    }

    public Akun(String role, String customer_name) {
        this.role = role;
        this.customer_name = customer_name;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Id
    public String getInstallation_code() {
        return installation_code;
    }

    public void setInstallation_code(String installation_code) {
        this.installation_code = installation_code;
    }

    public String getInstallation_address() {
        return installation_address;
    }

    public void setInstallation_address(String installation_address) {
        this.installation_address = installation_address;
    }

    public String getInstallation_type() {
        return installation_type;
    }

    public void setInstallation_type(String installation_type) {
        this.installation_type = installation_type;
    }

    public String getPower_capacity() {
        return power_capacity;
    }

    public void setPower_capacity(String power_capacity) {
        this.power_capacity = power_capacity;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getProfit_center() {
        return profit_center;
    }

    public void setProfit_center(String profit_center) {
        this.profit_center = profit_center;
    }

    public String getInstallation_number() {
        return installation_number;
    }

    public void setInstallation_number(String installation_number) {
        this.installation_number = installation_number;
    }

    public String getMultiply_fact() {
        return multiply_fact;
    }

    public void setMultiply_fact(String multiply_fact) {
        this.multiply_fact = multiply_fact;
    }

    public String getMinimum_used() {
        return minimum_used;
    }

    public void setMinimum_used(String minimum_used) {
        this.minimum_used = minimum_used;
    }

    public String getBiaya_admin() {
        return biaya_admin;
    }

    public void setBiaya_admin(String biaya_admin) {
        this.biaya_admin = biaya_admin;
    }

    public String getBiaya_beban() {
        return biaya_beban;
    }

    public void setBiaya_beban(String biaya_beban) {
        this.biaya_beban = biaya_beban;
    }

    public String getMinimum_payment() {
        return minimum_payment;
    }

    public void setMinimum_payment(String minimum_payment) {
        this.minimum_payment = minimum_payment;
    }
}