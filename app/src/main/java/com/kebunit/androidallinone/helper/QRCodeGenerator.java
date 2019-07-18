package com.kebunit.androidallinone.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kebunit.androidallinone.R;


public class QRCodeGenerator {
    private QRCodeWriter writer;
    private Bitmap bitmap;
    private Context context;

    public QRCodeGenerator(Context context) {
        this.context = context;
        this.writer = new QRCodeWriter();
    }

    public Bitmap createQR(String contents, int width, int height) {
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height);
            int widthQR = bitMatrix.getWidth();
            int heightQR = bitMatrix.getHeight();
            bitmap = Bitmap.createBitmap(widthQR, heightQR, Bitmap.Config.RGB_565);
            for (int x = 0; x < widthQR; x++) {
                for (int y = 0; y < heightQR; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
