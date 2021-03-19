package id.pelindo.remote.model;

import java.util.List;

public class ResponsePriceType {
    private String messageCode;
    private String messageDesc;
    private List<PriceType> listData;

    public ResponsePriceType(String messageCode, String messageDesc) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
    }

    public ResponsePriceType(String messageCode, String messageDesc, List<PriceType> list){
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

    public List<PriceType> getListData() {
        return listData;
    }

    public void setListData(List<PriceType> listData) {
        this.listData = listData;
    }
}
