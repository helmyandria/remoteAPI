package id.pelindo.remote.model;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseNoMeter {

    private String messageCode;
    private String messageDesc;
    private ObjectNode response;

    public ResponseNoMeter(String messageCode, String messageDesc, ObjectNode response) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
        this.response = response;
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

    public ObjectNode getResponse() {
        return response;
    }

    public void setResponse(ObjectNode response) {
        this.response = response;
    }

}
