package trungnt.mad3.techkids.smsmessage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.BoringLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //initDisplayListSMSMessage();
    }

    private void initDisplayListSMSMessage()
    {
//        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//
//            }
//        };

        //IntentFilter intentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        //thong bao cho He thong biet dung SMS_RECEIVED_ACTION de nhan tin nhan thong qua BroadCastReceiver
        //SMSBroadCastReceiver broadcastReceiver = new SMSBroadCastReceiver();
        //this.registerReceiver(broadcastReceiver, intentFilter);
//        ListSMSMessageAdapter listSMSMessageAdapter = new ListSMSMessageAdapter((Context)this, R.layout.activity_main );
    }

}
