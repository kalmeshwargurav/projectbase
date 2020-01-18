package in.kalmesh.projectbase;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Kalmeshwar on 18 Jan 2020 at 18:51.
 */
public class ValueExtractor {
    private Bundle bundle = null;

    public ValueExtractor(Activity mActivity) {
        bundle = mActivity.getIntent().getExtras();
    }

    public boolean isNotNull() {
        return bundle != null;
    }

    private boolean checkConditions(String key) {
        return (isNotNull() && bundle.containsKey(key));
    }

    public String getValue(String key, String defaultValue) {
        return checkConditions(key) ? bundle.getString(key) : defaultValue;
    }

    public int getValue(String key, int defaultValue) {
        return checkConditions(key) ? bundle.getInt(key) : defaultValue;
    }

    public boolean getValue(String key, boolean defaultValue) {
        return checkConditions(key) ? bundle.getBoolean(key) : defaultValue;
    }


}
