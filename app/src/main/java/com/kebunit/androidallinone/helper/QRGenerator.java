package com.kebunit.androidallinone.helper;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @author Sabituddin Bigbang
 * @since 2019
 */

public class QRGenerator {

    public static Bitmap generate(String contents, int width, int height) {
        Bitmap bitmap = null;
        try {
            QRCodeWriter writer = new QRCodeWriter();
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
