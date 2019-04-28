package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.SignInActivity;
import smile.algeria.khadamet.restaurantadmin.utils.CacheUtils;
import smile.algeria.khadamet.restaurantadmin.utils.LocaleHelper;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPreferences sharedpreferences;
    private static final String PREFS_FILE = "shared_preference_language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

        if (sharedpreferences.getString("language","en").equalsIgnoreCase("fr")) {
            LocaleHelper.setLocale(this, "fr");
        } else {
            LocaleHelper.setLocale(this, "en");
        }

        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, SignInActivity.class));
                finish();
            }
        },3000);
    }
}
