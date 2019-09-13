package in.kalmesh.projectbase;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtility {
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    public static String ZWING_APP_NAME = "zwing_app_name";

    public SharedPreferencesUtility(Context context) {
        this.sharedPref = context.getSharedPreferences(ZWING_APP_NAME, 0);
    }

    public void setString(String key, String value) {
        this.editor = this.sharedPref.edit();
        this.editor.putString(key, value);
        this.editor.apply();
    }

    public String getString(String key, String defaultVal) {
        return this.sharedPref.getString(key, defaultVal);
    }

    public void setBoolean(String key, boolean value) {
        this.editor = this.sharedPref.edit();
        this.editor.putBoolean(key, value);
        this.editor.apply();
    }

    public boolean getBoolean(String key, boolean defaultVal) {
        return this.sharedPref.getBoolean(key, defaultVal);
    }

    public void setInteger(String key, int value) {
        this.editor = this.sharedPref.edit();
        this.editor.putInt(key, value);
        this.editor.apply();
    }

    public int getInteger(String key, int defaultVal) {
        return this.sharedPref.getInt(key, defaultVal);
    }

    public void clearStoredValues() {
        this.editor = this.sharedPref.edit();
        this.editor.clear();
        this.editor.apply();
    }

    public void removeValue(String key) {
        this.editor = this.sharedPref.edit();
        this.editor.remove(key);
        this.editor.apply();
    }
}
