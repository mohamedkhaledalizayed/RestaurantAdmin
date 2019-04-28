package smile.algeria.khadamet.restaurantadmin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;


import org.json.JSONException;
import org.json.JSONObject;

import asia.fivejuly.securepreferences.SecurePreferences;

public class CacheUtils {

    private static final String ENCRYPT_KEY = "restaurant@742mhfs9$", PREFS_FILE = "restaurant_admin_prefs";

    @NonNull
    public static SharedPreferences getSharedPreferences(Context context) {
        return new SecurePreferences.Builder(context)
                .password(ENCRYPT_KEY)
                .filename(PREFS_FILE)
                .build();
    }

    public static String getUserLanguage(Context context,String key){
        Configuration config = context.getResources().getConfiguration();
        String lang = getSharedPreferences(context).getString(key, config.locale.getLanguage());
        return lang;
    }

    public static void clearCache(Context context) {
        getSharedPreferences(context).edit().clear().apply();
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getSharedPreferences(context).getString(key, defaultValue);
    }

}
