# trungnt-android3-assignment6
##Yêu cầu
+ Xây dựng Ứng dụng Nhận Tin nhắn 
+ Hiển thị tin nhắn ra ListView
![BTVN-Ứng dụng Nhận Tin Nhắn](http://i477.photobucket.com/albums/rr132/trungepu/BTVN-2442016-HungTD-Teacher-Message_zpst4hsxmh9.jpg) 

+ Cải tiến bài Ứng dụng Nhắn tin như hình dưới đây
![BTVN-2742016-Receive/SendSMS](http://i477.photobucket.com/albums/rr132/trungepu/BTVN-242016-Receive-SendSMS_zpsvnsoforl.jpg)

##Cần Kiến thức:
+ Hiểu về Intent kiểu tường minh và không tường minh
+ Biết sử dụng Broad Receive 

##Chú ý khi code
+ Nhớ cấp quyền READ, WRITE, RECEIVE trong file Manifest.xml để Hệ thống Android biết app của ta được cấp các quyền này và được tác động vào tin SMS
```
    <uses-permission android:name="android.permission.WRITE_SMS" />
    <uses-permission android:name="android.permission.READ_SMS" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
```

+ Đăng ký cho Hệ thống biết app của ta được phép nhận và xử lý tin nhắn SMS trong file Mainfest.xml
```
          <receiver android:name=".SMSBroadCastReceiver" android:exported="true" >
            <intent-filter>
                <action android:name="android.provider.Telephony.SMS_RECEIVED" />
            </intent-filter>
        </receiver>
```

+  Kết nối giao diện ListView Sms Message và dữ liệu arrSMS Messaage, sau đó hiển thị trên ListView 
```
   private void initDisplayListSMSMessage()
    {
        ListSMSMessageAdapter listSMSMessageAdapter = new ListSMSMessageAdapter((Context)this, R.layout.sms_message_template, SMSMessageManager.getInstance().getArrSMSMessage());
        listViewSMSMessage = (ListView) this.findViewById(R.id.lvDisplaySMSList);
        listViewSMSMessage.setAdapter(listSMSMessageAdapter);
    }

```

+ Nhận tin nhắn SMS và hiển thị Notification cho người dùng biết có SMS được gửi đến
```
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
                SMSMessage osmsMessage = new SMSMessage(address, smsBody);
                SMSMessageManager.getInstance().getArrSMSMessage().add(osmsMessage);


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
```

##Môi trường phát triển
+ Bộ công cụ Android Studio 2.0
+ Máy ảo Genymotion với Hệ điều hành Android version 4.3
+ Máy thật Samsumg Glaxy S3 với Hệ điều hành Android version 4.3

##Tham khảo
+ [Receive SMS Message](http://javapapers.com/android/android-receive-sms-tutorial/)
+ [Material Desing Icon](https://materialdesignicons.com/)
+ [Cài AVD ở ổ D](http://www.tech-recipes.com/rx/6588/how-to-install-android-sdk-without-internet-connection/)
+ [Tạo và sử dụng SD Card cho AVD](http://code5s.com/di-dong/android/tao-v-su-dung-sd-card-cho-avd.html)
