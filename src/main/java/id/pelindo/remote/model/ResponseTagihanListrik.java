package id.pelindo.remote.model;

import javax.persistence.Id;
import java.util.List;

public class ResponseTagihanListrik {

    private String messageCode;
    private String messageDesc;
    private String price_type;
    private String meter_to;
    private String meter_from;
    private String ppju;
    private String tariff;
    private String amount;
    private String period;
    private String installation_code;
    private Long id;
    private List<TagihanListrik> listTagihanListrik;

    public ResponseTagihanListrik(String messageCode, String messageDesc) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
    }

    public ResponseTagihanListrik(String messageCode, String messageDesc, List<TagihanListrik> list) {
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
        this.listTagihanListrik = list;
    }

    public List<TagihanListrik> getListTagihanListrik() {
        return listTagihanListrik;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public String getInstallation_code() {
        return installation_code;
    }

    public void setInstallation_code(String installation_code) {
        this.installation_code = installation_code;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPrice_type() {
        return price_type;
    }

    public void setPrice_type(String price_type) {
        this.price_type = price_type;
    }

    public String getMeter_to() {
        return meter_to;
    }

    public void setMeter_to(String meter_to) {
        this.meter_to = meter_to;
    }

    public String getMeter_from() {
        return meter_from;
    }

    public void setMeter_from(String meter_from) {
        this.meter_from = meter_from;
    }

    public String getPpju() {
        return ppju;
    }

    public void setPpju(String ppju) {
        this.ppju = ppju;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
