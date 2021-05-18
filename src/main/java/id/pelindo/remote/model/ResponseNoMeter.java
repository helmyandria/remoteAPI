package id.pelindo.remote.model;

public class ResponseNoMeter {

    private String messageCode;
    private String messageDesc;

    public ResponseNoMeter(String messageCode, String messageDesc) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
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

}
