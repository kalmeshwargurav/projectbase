package in.kalmesh.projectbase;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtility {
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    public static String PREF_NAME = "pref_kalmesh";

    public SharedPreferencesUtility(Context context) {
        this.sharedPref = context.getSharedPreferences(PREF_NAME, 0);
    }

    public void setString(String key, String value) {
        synchronized (this) {
            this.editor = this.sharedPref.edit();
            this.editor.putString(key, value);
            this.editor.apply();
        }
    }

    public String getString(String key, String defaultVal) {
        synchronized (this) {
            return this.sharedPref.getString(key, defaultVal);
        }
    }

    public void setBoolean(String key, boolean value) {
        synchronized (this) {
            this.editor = this.sharedPref.edit();
            this.editor.putBoolean(key, value);
            this.editor.apply();
        }
    }

    public boolean getBoolean(String key, boolean defaultVal) {
        synchronized (this) {
            return this.sharedPref.getBoolean(key, defaultVal);
        }
    }

    public void setInteger(String key, int value) {
        synchronized (this) {
            this.editor = this.sharedPref.edit();
            this.editor.putInt(key, value);
            this.editor.apply();
        }
    }

    public int getInteger(String key, int defaultVal) {
        synchronized (this) {
            return this.sharedPref.getInt(key, defaultVal);
        }
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