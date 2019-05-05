package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityDashboardBinding;
import smile.algeria.khadamet.restaurantadmin.views.dialog.ChartDialog;

public class DashboardActivity extends AppCompatActivity {

    private Calendar calendar;
    private DatePickerDialog picker;
    private ArrayList<String> items=new ArrayList<>();
    private SpinnerDialog spinnerDialog;
    private Date currentDate;
    private String date;
    private ActivityDashboardBinding binding;
    private int selectedItem= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.dashboard);
        calendar = Calendar.getInstance();

        DateFormat format = new SimpleDateFormat("yyyy", new Locale("en"));
        currentDate = new Date();
        date = format.format(currentDate);
        binding.year.setText(date);
    }

    public void daily(View view) {
        selectedItem = 1;
        binding.daily.setBackgroundResource(R.drawable.completedl_order_btn_bg);
        binding.monthly.setBackgroundResource(R.drawable.dashboard_background);
        binding.weekly.setBackgroundResource(R.drawable.dashboard_background);
        picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                binding.selectedDate.setText(i2+" : "+i1+" : "+i);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        picker.show();
    }

    public void weekly(View view) {
        selectedItem = 2;
        binding.weekly.setBackgroundResource(R.drawable.completedl_order_btn_bg);
        binding.monthly.setBackgroundResource(R.drawable.dashboard_background);
        binding.daily.setBackgroundResource(R.drawable.dashboard_background);
        items.clear();

        for (int i = 1 ; i <= 52 ; i++ ){
            items.add(getString(R.string.week)+i);
        }
        spinnerDialog=new SpinnerDialog(this,items,getString(R.string.select_week),R.style.DialogAnimations_SmileWindow,getString(R.string.close));// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(DashboardActivity.this, item + "  " + position+"", Toast.LENGTH_SHORT).show();
                binding.selectedDate.setText(item +" : "+date);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

    public void monthly(View view) {
        selectedItem = 3;
        binding.monthly.setBackgroundResource(R.drawable.completedl_order_btn_bg);
        binding.weekly.setBackgroundResource(R.drawable.dashboard_background);
        binding.daily.setBackgroundResource(R.drawable.dashboard_background);
        items.clear();

        items.addAll(Arrays.asList(getResources().getStringArray(R.array.array_months)));

        spinnerDialog=new SpinnerDialog(this,items,getString(R.string.select_month),R.style.DialogAnimations_SmileWindow,getString(R.string.close));// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(DashboardActivity.this, item + "  " + position+"", Toast.LENGTH_SHORT).show();
                binding.selectedDate.setText(item +" : "+date);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

    public void increaseYear(View view) {
        calendar.add(Calendar.YEAR,1);
        currentDate=calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy", new Locale("en"));
        String output = sdf1.format(calendar.getTime());
        date = output;
        binding.year.setText(date);
    }

    public void decreaseYear(View view) {
        calendar.add(Calendar.YEAR,-1);
        currentDate=calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy", new Locale("en"));
        String output = sdf1.format(calendar.getTime());
        date = output;
        binding.year.setText(date);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showChart() {
        FragmentManager fm = getSupportFragmentManager();
        ChartDialog editNameDialogFragment = ChartDialog.newInstance();
        editNameDialogFragment.show(fm, "Send Email Dialog");
        editNameDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
    }

    public void ordered(View view) {
        if (selectedItem == 1){

        }else {
          showChart();
        }
    }

    public void completed(View view) {
        if (selectedItem == 1){

        }else {
            showChart();
        }
    }

    public void canceled(View view) {
        if (selectedItem == 1){

        }else {
            showChart();
        }
    }

    public void delivery(View view) {
        if (selectedItem == 1){

        }else {
            showChart();
        }
    }

    public void pickup(View view) {
        if (selectedItem == 1){

        }else {
            showChart();
        }
    }

    public void income(View view) {
        if (selectedItem == 1){

        }else {
            showChart();
        }
    }
}