package com.kebunit.androidallinone.activity.timercountdown;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kebunit.androidallinone.R;

public class CountdownTimerActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView timerMinute, timerSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coundown_timer);

        progressBar = findViewById(R.id.progressBar);
        timerMinute = findViewById(R.id.timer_minute);
        timerSecond = findViewById(R.id.timer_second);

        new CountDownTimer(60000, 1) {

            public void onTick(long millisUntilFinished) {
                int secondCount = (int)millisUntilFinished / 1000;
                progressBar.setMax(60000);
                progressBar.setProgress((int)millisUntilFinished);
                int minute = secondCount / 60;
                int second = secondCount % 60;
                timerMinute.setText(""+minute+" : ");
                timerSecond.setText(""+second);
            }

            public void onFinish() {
                timerMinute.setText("");
                progressBar.setProgress(0);
                timerSecond.setText("Done!");
            }
        }.start();
    }
}
