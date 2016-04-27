package trungnt.mad3.techkids.smsmessage;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by TrungNT on 4/26/2016.
 */
public class SMSMessageManager extends Application {
    private static SMSMessageManager ourInstance = new SMSMessageManager();
    private ArrayList<Message> arrListSMSMessage = new ArrayList<>();

    public ArrayList<Message> getArrSMSMessage() {
        return arrListSMSMessage;
    }

    public static SMSMessageManager getOurInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
    }
}
