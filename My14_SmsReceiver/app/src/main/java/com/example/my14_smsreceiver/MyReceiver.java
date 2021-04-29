package com.example.my14_smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "main:MyReceiver";
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive : 호출됨");
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages !=null && messages.length>0){
            Log.d(TAG, "onReceive: SMS를 수신하였습니다.");
            String sender = messages[0].getOriginatingAddress();
            Log.d(TAG, "sender: "+sender);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.d(TAG, "receivedDate: "+receivedDate);

            // 메세지 내용
            String contents = messages[0].getMessageBody();
            Log.d(TAG, "contents : " + contents);

            Intent disIntent = new Intent(context, SmsDisActivity.class);
            disIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            disIntent.putExtra("sender" , sender);
            disIntent.putExtra("receivedDate" , dateFormat.format(receivedDate));
            disIntent.putExtra("contents" , contents);
            context.startActivity(disIntent);

        }
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objects = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objects.length];

        for (int i = 0; i < objects.length; i++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objects[i],format);
            }
        }
        return messages;

    }
}