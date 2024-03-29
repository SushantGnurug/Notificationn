package com.example.notifiation;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createChannel.CreateChannel;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;

    private Button btnDisplayNotification;
    private Button btnDisplayNotification2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel =new CreateChannel(this);
        channel.createChannel();

        btnDisplayNotification=findViewById(R.id.btnDisplayNotification);
        btnDisplayNotification2=findViewById(R.id.btnDisplayNotification2);

        btnDisplayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });

        btnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });



    }

    private void DisplayNotification(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);
    }


    private void DisplayNotification2(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2,notification);
    }

}
