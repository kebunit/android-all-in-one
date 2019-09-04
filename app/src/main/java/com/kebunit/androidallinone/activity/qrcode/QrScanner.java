package com.kebunit.androidallinone.activity.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class QrScanner {

    public static String getQrFromQrBitmap(Context context, Bitmap bitmap) {
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(context)
                .setBarcodeFormats(Barcode.QR_CODE).build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Barcode> barsCode = barcodeDetector.detect(frame);
        Barcode result = barsCode.valueAt(0);
        return result.rawValue;
    }
}
