package in.kalmesh.projectbase;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public abstract class AppActivity extends AppCompatActivity {
    private ProgressDialog pDialog = null;

    public AppActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.onCreateView());
        this.preInitializeMethod();
        this.initUI();
        this.postInitializeMethod();
    }

    public abstract int onCreateView();

    protected abstract void preInitializeMethod();

    protected void setToolbar() {

    }

    protected abstract void initUI();

    protected void setColorTheme() {

    }

    protected abstract void postInitializeMethod();

    protected void showDialog(boolean setCancelable) {
        if (pDialog == null || !pDialog.isShowing()) {
            pDialog = new ProgressDialog(AppActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(setCancelable);
            if (!isFinishing())
                pDialog.show();
        }
    }

    protected void hideDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            if (!isFinishing())
                pDialog.dismiss();
        }
    }
}