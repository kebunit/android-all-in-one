package com.kebunit.androidallinone.activity.qrcode;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.SparseArray;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.customview.PopupView;

import java.io.IOException;

public class ScannerActivity extends AppCompatActivity {

    private SurfaceView cameraPreview;
    private TextView resultText;
    private com.kebunit.androidallinone.activity.qrcode.CameraSource cameraSource;
    private ImageView torchButton, backButton;
    private LinearLayout tracer, tracerHorizontal;

    private BarcodeDetector barcodeDetector;
    private boolean isOnFlash = true, isSuccess = true;
    private Camera  camera;
    private Handler handler;
    String msgBefore="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        cameraPreview = (SurfaceView) findViewById(R.id.camera_preview);
        torchButton = (ImageView) findViewById(R.id.tochlight);
        tracer = (LinearLayout) findViewById(R.id.tracer);
        tracerHorizontal = (LinearLayout) findViewById(R.id.tracer_horizontal);
        backButton = (ImageView) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(Message message) {
                String msg = (String)message.obj;
                if (!msgBefore.equals(msg)) {
                    Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(1000);
                    msgBefore = msg;
                    showDialog(msg);
                }
            }
        };

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        ObjectAnimator animation = ObjectAnimator.ofFloat(tracer, "translationY", size.y);
        animation.setDuration(3000);
        animation.setRepeatCount(ValueAnimator.INFINITE);
        animation.setRepeatMode(ValueAnimator.REVERSE);
        animation.start();

        ObjectAnimator animation2 = ObjectAnimator.ofFloat(tracerHorizontal, "translationX", size.x);
        animation2.setDuration(3000);
        animation2.setRepeatCount(ValueAnimator.INFINITE);
        animation2.setRepeatMode(ValueAnimator.REVERSE);
        animation2.start();

        torchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnFlash) {
                    cameraSource.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    torchButton.setImageResource(R.drawable.flash_on);
                    isOnFlash = false;
                } else {
                    cameraSource.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    torchButton.setImageResource(R.drawable.flash_off);
                    isOnFlash = true;
                }

            }
        });

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE).build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(size.x, size.y).build();

        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(ScannerActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if (qrCodes.size() != 0) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Message message = new Message();
                            message.obj = qrCodes.valueAt(0).displayValue;
                            message.setTarget(handler);
                            message.sendToTarget();
                        }
                    }).start();
                } else {
                    isSuccess = false;
                }
            }
        });
    }



    private void showDialog(String resultText) {
        View itemView = getLayoutInflater().inflate(R.layout.popup_result, null);
        ImageView closeButton = (ImageView)itemView.findViewById(R.id.close_btn);
        TextView result = (TextView) itemView.findViewById(R.id.result_text);
        result.setText(resultText);
        final PopupView popupView = new PopupView(this, itemView);
        popupView.setCancelable(true);
        popupView.show();
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgBefore = "";
                popupView.cancel();

            }
        });
    }

    private void flashLight(boolean isOn) {
        if (isOn) {

        } else {

            //ToDo something
            camera = Camera.open();
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.stopPreview();
            camera.release();

        }
    }

}
