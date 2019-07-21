package com.kebunit.androidallinone.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author Sabituddin Bigbang
 * @since 2019
 */


public class ImageHelper {
    private static File file;

    /**
     * Share an Image from Bitmap
     * @param context
     * @param bitmap
     * @param name
     */
    public static void share(Context context, Bitmap bitmap, String name) {
        Activity activity = (Activity)context;
        try {
            file = new File(activity.getApplication().getExternalCacheDir(), name);
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.setType("image/png");
        activity.startActivity(Intent.createChooser(intent, "Share image via"));
    }

    /**
     * Convert View to Bitmap
     * @param view
     * @return
     */
    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return returnedBitmap;
    }

    /**
     * Convert Resource Image to Bitmap
     * @param context
     * @param resource
     * @return
     */
    public static Bitmap getBitmapFromResource(Context context, int resource) {
        return BitmapFactory.decodeResource(context.getResources(), resource);
    }
}
