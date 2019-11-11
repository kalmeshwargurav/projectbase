package in.kalmesh.androidlibrary;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import in.kalmesh.projectbase.AppActivity;
import in.kalmesh.projectbase.Validator;

public class MainActivity extends AppActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private Context mContext = null;

    @Override
    public int onCreateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void preInitializeMethod() {
        showDialog(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideDialog();
            }
        }, 6000);

        mContext = this;
    }

    @Override
    protected void initUI() {
        if (Validator.getInstance().isContainsDigits("12as"))
            Toast.makeText(mContext, "True", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "False", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void postInitializeMethod() {
        if (Validator.getInstance().hasLength("12345", 5))
            Toast.makeText(mContext, "yes", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "no", Toast.LENGTH_SHORT).show();

        if (Validator.getInstance().isLessThan("12345", 5))
            Toast.makeText(mContext, "True", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "False", Toast.LENGTH_SHORT).show();

        if (Validator.getInstance().isGreaterThan("12345", 4))
            Toast.makeText(mContext, "yes", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "no", Toast.LENGTH_SHORT).show();
    }
}