package com.kebunit.androidallinone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.kebunit.androidallinone.gridview.GridViewActivity;
import com.kebunit.androidallinone.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout gridClick, listClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridClick = (LinearLayout)findViewById(R.id.grid_click);
        gridClick.setOnClickListener(this);

        listClick = (LinearLayout)findViewById(R.id.list_click);
        listClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_click :
                Intent intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.grid_click :
                intent = new Intent(this, GridViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
