package xyz.matirbank.app.services.interfaces;

import java.util.Set;

public interface ISharedPreference {

    /* Save Preference */

    void savePreference(String key, String value);

    void savePreference(String key, Set<String> value);

    void savePreference(String key, boolean value);

    void savePreference(String key, int value);

    void savePreference(String key, float value);

    void savePreference(String key, long value);

    /* Load Preference */

    String loadPreference(String key, String defaultValue);

    Set<String> loadPreference(String key, Set<String> defaultValue);

    boolean loadPreference(String key, boolean defaultValue);

    int loadPreference(String key, int defaultValue);

    float loadPreference(String key, float defaultValue);

    long loadPreference(String key, long defaultValue);
}
