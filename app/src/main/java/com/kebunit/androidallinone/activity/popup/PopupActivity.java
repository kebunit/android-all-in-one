package com.kebunit.androidallinone.activity.popup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.helper.PopupView;

public class PopupActivity extends AppCompatActivity {
    private CardView dialodButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Popup View");
        setContentView(R.layout.popup_example);
        dialodButton = findViewById(R.id.show_dialog);
        dialodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        View itemView = getLayoutInflater().inflate(R.layout.popup_view, null);
        ImageView closeButton = (ImageView)itemView.findViewById(R.id.close_btn);

        final PopupView popupView = new PopupView(this, itemView);
        popupView.setCancelable(true);
        popupView.show();
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupView.cancel();
            }
        });
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
