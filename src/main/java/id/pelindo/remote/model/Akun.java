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
    private String customer_name;
    private String installation_code;
    private String installation_address;
    private String installation_type;
    private String power_capacity;

    public Akun() {
    }

    public Akun(String role, String customer_name) {
        this.role = role;
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

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

}