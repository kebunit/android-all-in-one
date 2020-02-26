package com.kebunit.androidallinone.activity.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.kebunit.androidallinone.R;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("View Pager");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_container, new ViewPagerFragment())
                .commit();
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
