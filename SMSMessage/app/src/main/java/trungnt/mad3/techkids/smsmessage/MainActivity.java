package trungnt.mad3.techkids.smsmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String SMS_BUNDLE = "pdus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        initDisplayListSMSMessage();
    }

    private void initDisplayListSMSMessage()
    {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle intentExtras = intent.getExtras();
                if (intentExtras != null) {
                    Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
                    String smsMessageStr = "";
                    for (int i = 0; i < sms.length; ++i) {
                        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                        String smsBody = smsMessage.getMessageBody().toString();
                        String address = smsMessage.getOriginatingAddress();

                        smsMessageStr += "SMS From: " + address + "\n";
                        smsMessageStr += smsBody + "\n";
                    }
                    Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        //thong bao cho He thong biet dung SMS_RECEIVED_ACTION de nhan tin nhan thong qua BroadCastReceiver
        this.registerReceiver(broadcastReceiver, intentFilter);

        //ListSMSMessageAdapter listSMSMessageAdapter = new ListSMSMessageAdapter((Context)this, R.layout.activity_main );
    }




}
