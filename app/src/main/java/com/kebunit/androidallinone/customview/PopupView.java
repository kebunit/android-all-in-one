package com.kebunit.androidallinone.customview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import com.kebunit.androidallinone.R;

/**
 * @author Sabituddin Bigbang
 * @since 2019
 */


public class PopupView {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Context context;
    private View view;

    public PopupView(Context context, View view) {
        this.context = context;
        this.view = view;
        this.builder = new AlertDialog.Builder(context, R.style.PopupView);
        this.builder.setView(this.view);
        this.dialog = this.builder.create();
        if (dialog.getWindow() != null) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
        }
    }

    public void show() {
        dialog.show();
    }

    public void setCancelable(boolean flag) {
        dialog.setCancelable(flag);
    }

    public void cancel() {
        dialog.cancel();
    }
}
