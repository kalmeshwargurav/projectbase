package in.kalmesh.projectbase;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public abstract class AppFragment extends Fragment {
    private ProgressDialog pDialog = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(this.onCreateView(), container, false);

        int sdk = Build.VERSION.SDK_INT;
        if (sdk > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.preInitializeMethod();
        this.initUI(view);
        this.postInitializeMethod();
    }

    public abstract int onCreateView();

    protected abstract void preInitializeMethod();

    protected abstract void initUI(View itemView);

    protected abstract void postInitializeMethod();

    protected void showDialog(boolean setCancelable) {
        if (pDialog == null || !pDialog.isShowing()) {
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(setCancelable);
            if (!Objects.requireNonNull(getActivity()).isFinishing())
                pDialog.show();
        }
    }

    protected void hideDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            if (!Objects.requireNonNull(getActivity()).isFinishing())
                pDialog.dismiss();
        }
    }
}
