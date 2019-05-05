package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityOngoingOrderBinding;
import smile.algeria.khadamet.restaurantadmin.utils.AppUtils;
import smile.algeria.khadamet.restaurantadmin.views.adapter.ItemsAdapter;

public class OngoingOrderActivity extends AppCompatActivity {

    private ActivityOngoingOrderBinding binding;
    private ItemsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ongoing_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.in_progress_order);

        mAdapter = new ItemsAdapter(this,new ArrayList<String>());
        binding.itemsRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.itemsRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.itemsRecycler.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void cancel(View view) {
        AppUtils.dialog(this,"Cancel Order","Are You Want To Cancel Order !");
    }

    public void call(View view) {
        call("098765432");
    }

    public void navigate(View view) {
        AppUtils.openMap(this,98,78);
    }

    public void call(String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
