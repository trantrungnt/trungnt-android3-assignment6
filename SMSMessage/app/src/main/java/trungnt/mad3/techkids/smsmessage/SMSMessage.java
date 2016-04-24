package trungnt.mad3.techkids.smsmessage;

/**
 * Created by TrungNT on 4/25/2016.
 */
public class SMSMessage {
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContentSMS() {
        return ContentSMS;
    }

    public void setContentSMS(String contentSMS) {
        ContentSMS = contentSMS;
    }

    private String phone;
    private String ContentSMS;

    private SMSMessage()
    {
        this.phone = "";
        this.ContentSMS = "";
    }

    public SMSMessage(String phone, String contentSMS)
    {
        this.phone = phone;
        this.ContentSMS = contentSMS;
    }
}
