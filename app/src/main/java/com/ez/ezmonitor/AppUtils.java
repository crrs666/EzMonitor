package com.ez.ezmonitor;

import android.content.Context;
import android.widget.Toast;

public class AppUtils {
    public static void toast(Context c, Object o) {
        Toast.makeText(c, o.toString(), Toast.LENGTH_SHORT).show();
    }
}
