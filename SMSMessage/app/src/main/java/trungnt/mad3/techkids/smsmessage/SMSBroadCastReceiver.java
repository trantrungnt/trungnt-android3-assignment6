package trungnt.mad3.techkids.smsmessage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by TrungNT on 4/25/2016.
 */
public class SMSBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] sms = (Object[]) bundle.get("pdus");
            for (int i = 0; i < sms.length; i++) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getDisplayMessageBody();
                String address = smsMessage.getDisplayOriginatingAddress();

                //Toast.makeText(context, smsBody + " - " + address, Toast.LENGTH_SHORT).show();

                //////////////////////////////////////////////////////////////////////////////////
                //luu so dien thoai va noi dung tin nhan vua nhan vao SMSMessageManager
                SMSMessage smsMessage = new SMSMessage(address, smsBody);
                SMSMessageManager.getInstance().getArrSMSMessage().add(smsMessage);


                ///////////////////////////////////////////////////////////////////////////////////
                //Hien thi Notification khi nhan duoc tin nhan SMS
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.message)
                                .setContentTitle(address)
                                .setContentText(smsBody);

                Intent resultIntent = new Intent(context, MainActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                stackBuilder.addParentStack(MainActivity.class);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(999, mBuilder.build());
            }
        }
    }
}
