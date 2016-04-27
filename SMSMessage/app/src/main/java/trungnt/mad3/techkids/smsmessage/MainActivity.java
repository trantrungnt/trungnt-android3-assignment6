package trungnt.mad3.techkids.smsmessage;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewSMSMessage;

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
//        ArrayList<Message> arrtemp = new ArrayList<>();
//        Message osmsmessage = new Message();
//        osmsmessage.setPhone("0");
//        osmsmessage.setContentSMS("Content body sms");
//        arrtemp.add(osmsmessage);

        ListSMSMessageAdapter listSMSMessageAdapter = new ListSMSMessageAdapter((Context) this, R.layout.sms_message_template, SMSMessageManager.getOurInstance().getArrSMSMessage());
        listViewSMSMessage = (ListView) this.findViewById(R.id.lvDisplaySMSList);
        listViewSMSMessage.setAdapter(listSMSMessageAdapter);


    }

}
