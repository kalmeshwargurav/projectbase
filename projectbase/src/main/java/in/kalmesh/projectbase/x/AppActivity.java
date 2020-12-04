package in.kalmesh.projectbase.x;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class AppActivity extends AppCompatActivity {
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
}