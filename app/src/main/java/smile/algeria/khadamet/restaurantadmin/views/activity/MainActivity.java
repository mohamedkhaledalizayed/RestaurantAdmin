package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.crowdfire.cfalertdialog.CFAlertDialog;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.FeedBackItemBinding;
import smile.algeria.khadamet.restaurantadmin.utils.AppUtils;
import smile.algeria.khadamet.restaurantadmin.utils.CacheUtils;
import smile.algeria.khadamet.restaurantadmin.utils.LocaleHelper;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        TextView textView=findViewById(R.id.toolbar_title);
        textView.setText(R.string.home);
        drawer = findViewById(R.id.drawer_layout);
//https://codinginfinite.com/dagger-retrofit-example-dependency-injection/
        //https://www.google.com/search?q=retrofit+dagger+example&oq=retrofit+dagger+ex&aqs=chrome.0.0j69i57j0l2.10710j0j4&sourceid=chrome&ie=UTF-8
        //https://www.youtube.com/watch?v=ijXjCtCXcN4&list=PLgCYzUzKIBE-eHpqt44Ea-Mi_iAUkpOdq
        //https://mshmshvalley.com/%D9%83%D9%88%D8%B1%D8%B3-english-%D9%85%D8%AC%D8%A7%D9%86%D9%8A-%D9%85%D9%86-%D8%A7%D9%84-british-council/

//https://medium.freecodecamp.org/25-new-android-libraries-which-you-definitely-want-to-try-at-the-beginning-of-2017-45878d5408c0
        //https://github.com/Gwokhov/Deadline

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_memu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void ordersOnline(View view) {
        startActivity(new Intent(this, OrderOnlineActivity.class));
    }

    public void menu(View view) {
        startActivity(new Intent(this, DealOfferActivity.class));
    }

    public void addNewCategory(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.profile:
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                break;

            case R.id.customer_feedback:
                startActivity(new Intent(MainActivity.this, FeedBackActivity.class));
                break;

            case R.id.settings:
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
                break;
//
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.logout:
                logout();

                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle("Logout")
                .setMessage("Are You Want To Logout.")
                .addButton("Ok", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).addButton("Cancel", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                ;

// Show the alert
        builder.show();
    }

    public void delivery(View view) {
        startActivity(new Intent(MainActivity.this,DeliveryActivity.class));
    }

    public void dashboard(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
    }

    public void support(View view) {
        startActivity(new Intent(MainActivity.this,SupportActivity.class));
    }
}
