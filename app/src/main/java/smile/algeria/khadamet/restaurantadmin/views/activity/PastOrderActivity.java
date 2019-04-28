package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityPastOrderBinding;
import smile.algeria.khadamet.restaurantadmin.views.adapter.ItemsAdapter;

public class PastOrderActivity extends AppCompatActivity {

    private ActivityPastOrderBinding binding;
    private ItemsAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_past_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.completed_order);

        mAdapter = new ItemsAdapter(this,new ArrayList<String>());
        binding.itemsRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.itemsRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.itemsRecycler.setAdapter(mAdapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
