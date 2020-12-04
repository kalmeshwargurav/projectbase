package in.kalmesh.projectbaselibrary;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import in.kalmesh.projectbase.Debug;
import in.kalmesh.projectbase.DecimalFormatter;
import in.kalmesh.projectbase.SharedPreferencesUtility;
import in.kalmesh.projectbase.Validator;
import in.kalmesh.projectbase.ValueExtractor;
import in.kalmesh.projectbase.x.AppActivity;

public class MainActivity extends AppActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private Context mContext = null;

    @Override
    public int onCreateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void preInitializeMethod() {
//        showDialog(false);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                hideDialog();
//            }
//        }, 6000);

        mContext = this;

        checkPermissions(MainActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE}, 12);

        String value2 = new DecimalFormatter().format("112.123");
        String value21 = new DecimalFormatter(2).format("112.1234");
        String value3 = new DecimalFormatter(3).format("112.1234");
        String value4 = new DecimalFormatter(-1).format("112.1234");

        Debug.printLogError(TAG, "preInitializeMethod: " + value2 + "\n" + value21 + "\n" + value3 + "\n" + value4, false);
    }

    public boolean checkPermissions(Activity act, String[] permissionName, int request_code) {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissionName) {
            result = ContextCompat.checkSelfPermission(act, p);
            if (result != PackageManager.PERMISSION_GRANTED)
                listPermissionsNeeded.add(p);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(act, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), request_code);
            return false;
        }
        return true;
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void postInitializeMethod() {
//        if (Validator.getInstance().isContainsDigits("12as"))
//            Toast.makeText(mContext, "True", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(mContext, "False", Toast.LENGTH_SHORT).show();
//
//        if (Validator.getInstance().hasLength("12345", 5))
//            Toast.makeText(mContext, "yes_hsLength", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(mContext, "no_hsLength", Toast.LENGTH_SHORT).show();
//
//        if (Validator.getInstance().isLessThan("12345", 5))
//            Toast.makeText(mContext, "True", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(mContext, "False", Toast.LENGTH_SHORT).show();
//
//        if (Validator.getInstance().isGreaterThan("12345", 4))
//            Toast.makeText(mContext, "yes_greater", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(mContext, "no_greater", Toast.LENGTH_SHORT).show();

        /*
         * Validator class
         * */
        Debug.printLogError(TAG, "postInitializeMethod_1: " + Validator.getInstance().checkEmpty("", 0), false);
        Debug.printLogError(TAG, "postInitializeMethod_2: " + Validator.getInstance().checkEmpty("", 0.00), false);
        Debug.printLogError(TAG, "postInitializeMethod_3: " + Validator.getInstance().checkEmpty("", "no_data"), false);

        ValueExtractor valueExtractor = new ValueExtractor(this);
        Debug.printLogError(TAG, "postInitializeMethod_4: "
                + valueExtractor.getValue("hasValue", ""), false);

        /*
         * Fetch value on second screen which is passed through intent.putExtra();
         * */
        String firstValue = valueExtractor.getValue("value1", "1");
        int secondValue = valueExtractor.getValue("value2", 2);
        boolean isAdd = valueExtractor.getValue("value3", false);

        /*
         * SharedPreferences class
         * */
        SharedPreferencesUtility sp = new SharedPreferencesUtility(mContext);
        sp.setString("key1", "komal");
        sp.setInteger("key2", 1224);
        sp.setBoolean("isPass", false);

        String str1 = sp.getString("key1", "komal");
        int int1 = sp.getInteger("key2", 0);
        boolean b1 = sp.getBoolean("isPass", false);
    }
}