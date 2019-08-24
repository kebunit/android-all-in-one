package com.kebunit.androidallinone.helper;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


/**
 * @author Sabituddin Bigbang
 * @since 2019
 */


public class SystemHelper {

    // Keyboard Utility
    public static void hideKeyboard(Activity activity) {
        InputMethodManager method = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        method.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
