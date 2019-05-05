package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch;
import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.utils.CacheUtils;
import smile.algeria.khadamet.restaurantadmin.utils.LocaleHelper;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "shared_preference_language";
    private TextView title,language;
    private Toolbar toolbar;
    private ToggleSwitch aSwitch;
    private LinearLayout layout;
    private SharedPreferences sharedpreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        title = findViewById(R.id.toolbar_title);
        language = findViewById(R.id.lang);
        layout = findViewById(R.id.layout_container);
        registerForContextMenu(layout);
        sharedpreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.settings));
        aSwitch = findViewById(R.id.language_option);

        aSwitch.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                if (position==0){
                    LocaleHelper.setLocale(SettingsActivity.this, "en");
//            CacheUtils.getSharedPreferences(SettingsActivity.this).edit().putString("language", "en").apply();
                    editor.putString("language", "en").commit();
//            languageName.setText("English");
                    recreate();
                }else {
                    LocaleHelper.setLocale(SettingsActivity.this, "fr");
//            CacheUtils.getSharedPreferences(this).edit().putString("language", "fr").apply();
                    editor.putString("language", "fr").commit();
//            languageName.setText("French");
                    recreate();
                }
            }
        });

        if (sharedpreferences.getString("language","en").equalsIgnoreCase("fr")) {
            aSwitch.setCheckedTogglePosition(1);
        } else {
            aSwitch.setCheckedTogglePosition(0);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu, menu);
        menu.setHeaderTitle("Select The Language");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.french){
            Toast.makeText(getApplicationContext(),"French",Toast.LENGTH_LONG).show();
            LocaleHelper.setLocale(SettingsActivity.this, "fr");
//            CacheUtils.getSharedPreferences(this).edit().putString("language", "fr").apply();
            editor.putString("language", "fr").commit();
//            languageName.setText("French");
            recreate();
        } else{
            Toast.makeText(getApplicationContext(),"English", Toast.LENGTH_LONG).show();
            LocaleHelper.setLocale(this, "en");
//            CacheUtils.getSharedPreferences(SettingsActivity.this).edit().putString("language", "en").apply();
            editor.putString("language", "en").commit();
//            languageName.setText("English");
            recreate();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}