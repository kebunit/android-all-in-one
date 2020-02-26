package com.kebunit.androidallinone.activity.notification;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.kebunit.androidallinone.R;

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
