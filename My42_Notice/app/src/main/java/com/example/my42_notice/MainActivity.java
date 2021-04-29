package com.example.my42_notice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager manager;
    String CHANNEL_ID1 = "channel1";
    String CHANNEL_NAME1 = "channel1";
    String CHANNEL_ID2 = "channel2";
    String CHANNEL_NAME2 = "channel2";
    String CHANNEL_ID3 = "channel3";
    String CHANNEL_NAME3 = "channel3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti1();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti2();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoti3();
            }
        });
    }

    private void showNoti1() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(manager.getNotificationChannel(CHANNEL_ID1)==null){
                manager.createNotificationChannel(new NotificationChannel(CHANNEL_ID1, CHANNEL_NAME1, NotificationManager.IMPORTANCE_DEFAULT));
            }
            builder = new NotificationCompat.Builder(this, CHANNEL_ID1);
        }else{
            builder = new NotificationCompat.Builder(this);
        }
        builder.setContentTitle("간단 알림").setContentText("간단알림 메세지입니다.").setSmallIcon(android.R.drawable.ic_menu_view);
        Notification noti = builder.build();
        manager.notify(1, noti);
    }

    private void showNoti2() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(manager.getNotificationChannel(CHANNEL_ID2)==null){
                manager.createNotificationChannel(new NotificationChannel(CHANNEL_ID2, CHANNEL_NAME2, NotificationManager.IMPORTANCE_DEFAULT));
            }
            builder = new NotificationCompat.Builder(this, CHANNEL_ID2);
        }else{
            builder = new NotificationCompat.Builder(this);
        }
        Intent intent = new Intent(this, SubActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1001, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("간단 알림 클릭").setContentText("클릭 알림 메세지입니다.").setSmallIcon(android.R.drawable.ic_menu_view)
        .setAutoCancel(true).setContentIntent(pendingIntent);
        Notification noti = builder.build();
        manager.notify(2, noti);
    }

    private void showNoti3() {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(manager.getNotificationChannel(CHANNEL_ID3)==null){
                manager.createNotificationChannel(new NotificationChannel(CHANNEL_ID3, CHANNEL_NAME3, NotificationManager.IMPORTANCE_DEFAULT));
            }
            builder = new NotificationCompat.Builder(this, CHANNEL_ID3);
        }else{
            builder = new NotificationCompat.Builder(this);
        }

        Intent intent = new Intent(this, SubActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1001, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("간단 알림 클릭").setContentText("클릭 알림 메세지입니다.").setSmallIcon(android.R.drawable.ic_menu_view)
        .setAutoCancel(true).setContentIntent(pendingIntent);

        Notification noti = builder.build();
        manager.notify(3, noti);
    }
}