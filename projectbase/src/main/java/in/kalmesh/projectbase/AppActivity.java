package in.kalmesh.projectbase;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import in.kalmesh.projectbase.x.ConnectionLiveData;
import in.kalmesh.projectbase.x.ConnectionModel;

public abstract class AppActivity extends AppCompatActivity {
    private ProgressDialog pDialog = null;

    public AppActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.onCreateView());
        this.preInitializeMethod();
        this.setToolbar();
        this.initUI();
        this.setColorTheme();
        this.postInitializeMethod();

        networkStatus();
    }

    protected abstract int onCreateView();

    protected abstract void preInitializeMethod();

    protected void setToolbar() {

    }

    protected abstract void initUI();

    protected void setColorTheme() {

    }

    protected abstract void postInitializeMethod();

    protected void onNetworkChange(boolean isNetworkAvailable) {

    }

    private void networkStatus() {
        ConnectionLiveData connectionLiveData = new ConnectionLiveData(AppActivity.this);
        connectionLiveData.observe(this, new Observer<ConnectionModel>() {
            @Override
            public void onChanged(@Nullable ConnectionModel connection) {
                if (connection.isConnected()) {
                    onNetworkChange(true);
                } else {
                    onNetworkChange(false);
                }
            }
        });
    }

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