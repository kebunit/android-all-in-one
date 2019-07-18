package com.kebunit.androidallinone.activity.horizontalscroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kebunit.androidallinone.R;

public class HorizontalScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_container, new HorizontalScrollFragment())
                .commit();
    }
}
