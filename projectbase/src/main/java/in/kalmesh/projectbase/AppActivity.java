package in.kalmesh.projectbase;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public abstract class AppActivity extends AppCompatActivity {
    public AppActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.onCreateView());
        this.preInitializeMethod();
        this.setToolbar();
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
}