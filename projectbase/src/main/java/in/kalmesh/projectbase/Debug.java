package in.kalmesh.projectbase;

import android.util.Log;

public class Debug {
    public static boolean LOG = true;

    public Debug() {
    }

    public static void printLog(String TAG, String message) {
        if (LOG)
            Log.d(TAG, message);
    }

    public static void printLogError(String TAG, String message) {
        if (LOG)
            Log.e(TAG, message);
    }

    public static void printLogV(String TAG, String message) {
        if (LOG)
            Log.v(TAG, message);
    }

    public static void printLogI(String TAG, String message) {
        if (LOG)
            Log.i(TAG, message);
    }

    public static void printLogW(String TAG, String message) {
        if (LOG)
            Log.w(TAG, message);
    }
}
