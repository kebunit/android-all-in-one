package com.kebunit.androidallinone.activity.camera;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.activity.qrcode.CameraSource;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
    private SurfaceView cameraPreview;
    private CameraSource cameraSource;
    private Context context;
    private BarcodeDetector barcodeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        cameraPreview = (SurfaceView) findViewById(R.id.camera_preview);
        context = this;
        initCamera();
    }

    private void initCamera() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        barcodeDetector = new BarcodeDetector.Builder(this).build();
        cameraSource = new com.kebunit.androidallinone.activity.qrcode.CameraSource.Builder(context, barcodeDetector)
                .setRequestedPreviewSize(size.x, size.y)
                .build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                try {
                    cameraSource.start(holder);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
}
