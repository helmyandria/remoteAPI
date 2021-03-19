package id.pelindo.remote.model;

import javax.persistence.Id;
import java.util.List;

public class ResponseAkun {
    private String messageCode;
    private String messageDesc;
//    private String username;
//    private String role;
    private List<Akun> listData;

    public ResponseAkun(String messageCode, String messageDesc) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
    }

    public ResponseAkun(String messageCode, String messageDesc, List<Akun> list) {
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
        this.listData = list;
    }

    @Id
    public String getMessageCode() {
        return messageCode;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public List<Akun> getListData() {
        return listData;
    }

    public void setListData(List<Akun> listData) {
        this.listData = listData;
    }

    //    @Id
//    public String getUsername() {
//        return username;
//    }
//
//    public String getRole() {
//        return role;
//    }
}