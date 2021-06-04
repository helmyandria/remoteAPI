package id.pelindo.remote.model.bbs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class BbsInputNoMeter implements Serializable {

    @JsonProperty("ServicesTransaction")
    private BbsServicesTransaction servicesTransaction;
    @JsonProperty("ServicesTransactionC")
    private List<BbsServicesTransactionC> serviceTransactionC;
    @JsonProperty("ServicesTransactionD")
    private List<BbsServicesTransactionD> servicesTransactionD;

    public BbsServicesTransaction getServicesTransaction() {
        return servicesTransaction;
    }

    public void setServicesTransaction(BbsServicesTransaction servicesTransaction) {
        this.servicesTransaction = servicesTransaction;
    }

    public List<BbsServicesTransactionC> getServiceTransactionC() {
        return serviceTransactionC;
    }

    public void setServiceTransactionC(List<BbsServicesTransactionC> serviceTransactionC) {
        this.serviceTransactionC = serviceTransactionC;
    }

    public List<BbsServicesTransactionD> getServicesTransactionD() {
        return servicesTransactionD;
    }

    public void setServicesTransactionD(List<BbsServicesTransactionD> servicesTransactionD) {
        this.servicesTransactionD = servicesTransactionD;
    }
}
