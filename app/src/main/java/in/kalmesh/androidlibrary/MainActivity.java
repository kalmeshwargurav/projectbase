package in.kalmesh.androidlibrary;

import android.content.Context;

import in.kalmesh.projectbase.AppActivity;
import in.kalmesh.projectbase.Debug;
import in.kalmesh.projectbase.Validator;
import in.kalmesh.projectbase.ValueExtractor;

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

        Debug.printLogError(TAG, "postInitializeMethod_1: " + Validator.getInstance().checkEmpty("", 0));
        Debug.printLogError(TAG, "postInitializeMethod_2: " + Validator.getInstance().checkEmpty("", 0.00));
        Debug.printLogError(TAG, "postInitializeMethod_3: " + Validator.getInstance().checkEmpty("", "no_data"));

        ValueExtractor valueExtractor = new ValueExtractor(this);
        Debug.printLogError(TAG, "postInitializeMethod_4: "
                + valueExtractor.getValue("hasValue", ""));
    }
}