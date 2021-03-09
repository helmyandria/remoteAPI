package id.pelindo.remote.model;

public class ResponseAkun {
    private String messageCode;
    private String messageDesc;
    private String username;
    private String role;

    public ResponseAkun(String messageCode, String messageDesc, String username, String role) {
        super();
        this.messageCode = messageCode;
        this.messageDesc = messageDesc;
        this.username = username;
        this.role = role;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}