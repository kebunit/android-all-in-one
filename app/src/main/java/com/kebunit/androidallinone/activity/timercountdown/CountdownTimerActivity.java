package com.kebunit.androidallinone.activity.timercountdown;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Countdown Timer");

        setContentView(R.layout.activity_coundown_timer);
        progressBar = findViewById(R.id.progressBar);
        timerMinute = findViewById(R.id.timer_minute);
        timerSecond = findViewById(R.id.timer_second);

        setCountdownTimer(60);
    }

    private void setCountdownTimer(int second) {
        final int timeInSecond = second*1000;
        new CountDownTimer(timeInSecond, 1) {
            public void onTick(long millisUntilFinished) {
                int secondCount = (int)millisUntilFinished / 1000;
                progressBar.setMax(timeInSecond);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return false;
        }
    }
}
