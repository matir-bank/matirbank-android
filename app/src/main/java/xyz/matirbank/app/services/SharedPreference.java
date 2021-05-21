package xyz.matirbank.app.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import xyz.matirbank.app.ThisApplication;
import xyz.matirbank.app.services.interfaces.ISharedPreference;

public class SharedPreference implements ISharedPreference {

    private final SharedPreferences sharedPref;
    private final SharedPreferences.Editor sharedPrefEdit;

    @SuppressLint("CommitPrefEdits")
    public SharedPreference() {
        ThisApplication.getInstance().getComponents().inject(this);
        sharedPref = ThisApplication.getContext().getSharedPreferences("Application", Context.MODE_PRIVATE);
        sharedPrefEdit = sharedPref.edit();
    }

    /* Save Preference */

    @Override
    public void savePreference(String key, String value) {
        sharedPrefEdit.putString(key, value);
        sharedPrefEdit.apply();
    }

    @Override
    public void savePreference(String key, Set<String> value) {
        sharedPrefEdit.putStringSet(key, value);
        sharedPrefEdit.apply();
    }

    @Override
    public void savePreference(String key, boolean value) {
        sharedPrefEdit.putBoolean(key, value);
        sharedPrefEdit.apply();
    }

    @Override
    public void savePreference(String key, int value) {
        sharedPrefEdit.putInt(key, value);
        sharedPrefEdit.apply();
    }

    @Override
    public void savePreference(String key, float value) {
        sharedPrefEdit.putFloat(key, value);
        sharedPrefEdit.apply();
    }

    @Override
    public void savePreference(String key, long value) {
        sharedPrefEdit.putLong(key, value);
        sharedPrefEdit.apply();
    }

    /* Load Preference */

    @Override
    public String loadPreference(String key, String defaultValue) {
        return sharedPref.getString(key, defaultValue);
    }

    @Override
    public Set<String> loadPreference(String key, Set<String> defaultValue) {
        return sharedPref.getStringSet(key, defaultValue);
    }

    @Override
    public boolean loadPreference(String key, boolean defaultValue) {
        return sharedPref.getBoolean(key, defaultValue);
    }

    @Override
    public int loadPreference(String key, int defaultValue) {
        return sharedPref.getInt(key, defaultValue);
    }

    @Override
    public float loadPreference(String key, float defaultValue) {
        return sharedPref.getFloat(key, defaultValue);
    }

    @Override
    public long loadPreference(String key, long defaultValue) {
        return sharedPref.getLong(key, defaultValue);
    }
}
