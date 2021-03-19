package id.pelindo.remote.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PriceType implements Serializable {

    private String id;
    private String installation_id;
    private String installation_code;
    private String price_type;
    private String price_code;
    private String max_range_used;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstallation_id() {
        return installation_id;
    }

    public void setInstallation_id(String installation_id) {
        this.installation_id = installation_id;
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

    public String getMax_range_used() {
        return max_range_used;
    }

    public void setMax_range_used(String max_range_used) {
        this.max_range_used = max_range_used;
    }

    public String getInstallation_code() {
        return installation_code;
    }

    public void setInstallation_code(String installation_code) {
        this.installation_code = installation_code;
    }
}
