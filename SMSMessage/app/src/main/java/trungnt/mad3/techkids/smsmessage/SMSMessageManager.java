package trungnt.mad3.techkids.smsmessage;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by TrungNT on 4/26/2016.
 */
public class SMSMessageManager extends Application {
    private static SMSMessageManager ourInstance = new SMSMessageManager();
    private ArrayList<SMSMessage> arrListSMSMessage = new ArrayList<>();

    public ArrayList<SMSMessage> getArrSMSMessage() {
        return arrListSMSMessage;
    }

    public static SMSMessageManager getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
    }
}
