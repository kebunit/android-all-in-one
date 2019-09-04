package com.kebunit.androidallinone.activity.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.activity.home.MainActivity;

public class NotificationActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "82374";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button button1 = findViewById(R.id.show_notification);
        Button button2 = findViewById(R.id.show_again);

        NotificationGenerator.generate(NotificationActivity.this, "au9d8a9s8dua9sfys9dfysf");
    }
}
