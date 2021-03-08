package exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String rc;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String rc, String message, String details) {
        super();
        this.rc = rc;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

}
