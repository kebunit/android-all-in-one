package com.kebunit.androidallinone.activity.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.helper.QRCodeGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QrGeneratorActivity extends AppCompatActivity {

    private Button generateQr, shareButton;
    private TextInputEditText inputSomething;
    private ImageView qrImage;
    private LinearLayout progressContainer;
    private TextInputLayout textLayout;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Generate QR Code");

        generateQr = findViewById(R.id.generate_button);
        inputSomething = findViewById(R.id.input_something);
        progressContainer = findViewById(R.id.progressbar_container);
        textLayout = findViewById(R.id.input_layout);
        qrImage = findViewById(R.id.qr_code);
        shareButton = findViewById(R.id.share_button);


        generateQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQr();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat jam = new SimpleDateFormat("HH.mm.ss");
                    SimpleDateFormat tanggal = new SimpleDateFormat("dd-MM-yyyy");
                    String name = "QR-generator"+ tanggal.format(calendar.getTime()) +" at " + jam.format(calendar.getTime()) +".png";
                    File file = new File(getApplication().getExternalCacheDir(),name);
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    intent.setType("image/png");
                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void generateQr() {
        if (TextUtils.isEmpty(inputSomething.getText().toString().trim())) {
            textLayout.setErrorEnabled(true);
            textLayout.setError("Field ini tidak boleh kosong");
        } else {
            textLayout.setErrorEnabled(false);
            qrImage.setVisibility(View.GONE);
            shareButton.setVisibility(View.GONE);
            progressContainer.setVisibility(View.VISIBLE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    QRCodeGenerator qrCodeGenerator = new QRCodeGenerator(QrGeneratorActivity.this);
                    bitmap = qrCodeGenerator.createQR(inputSomething.getText().toString(), 512, 512);
                    qrImage.post(new Runnable() {
                        @Override
                        public void run() {
                            progressContainer.setVisibility(View.GONE);
                            qrImage.setVisibility(View.VISIBLE);
                            qrImage.setImageBitmap(bitmap);
                            shareButton.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }).start();
        }

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
