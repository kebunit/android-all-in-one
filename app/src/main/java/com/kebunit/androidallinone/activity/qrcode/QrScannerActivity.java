package com.kebunit.androidallinone.activity.qrcode;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kebunit.androidallinone.R;

public class QrScannerActivity extends AppCompatActivity {
    private CardView scanButton;
    private LinearLayout resultContainer;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
        result = findViewById(R.id.scan_result);
        resultContainer = findViewById(R.id.result_container);
        scanButton = findViewById(R.id.scan_button);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QrScannerActivity.this, ScannerActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }
}
