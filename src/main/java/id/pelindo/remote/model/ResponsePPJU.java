package id.pelindo.remote.model;

import java.util.List;

public class ResponsePPJU {

    private String messageCode;
    private String messageDesc;
    private List<PPJU> listData;

    public ResponsePPJU (String messageCode, String messageDesc){
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
    }

    public ResponsePPJU(String messageCode, String messageDesc, List<PPJU> list){
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
        this.listData = list;
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

    public List<PPJU> getLisData() {
        return listData;
    }

    public void setLisData(List<PPJU> listData) {
        this.listData = listData;
    }
}
