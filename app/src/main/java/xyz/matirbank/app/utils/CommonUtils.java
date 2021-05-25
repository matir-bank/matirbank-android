package xyz.matirbank.app.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class CommonUtils {

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public static boolean isExpired(long time) {
        if(time > getCurrentTime()) {
            return true;
        } else {
            return false;
        }
    }

}
