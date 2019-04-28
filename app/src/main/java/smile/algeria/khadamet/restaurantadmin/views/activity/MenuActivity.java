package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.views.adapter.MenuAdapter;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityMenuBinding;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IMenuHandler;

public class MenuActivity extends AppCompatActivity implements IMenuHandler {

    private ActivityMenuBinding binding;
    private MenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Menu");
        mAdapter = new MenuAdapter(this,new ArrayList<String>());
        binding.menuRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.menuRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.menuRecycler.setAdapter(mAdapter);
    }

    public void addNewItem(View view) {
        startActivity(new Intent(this, AddNewItemActivity.class));
    }

    public void addNewCategory(View view) {
        startActivity(new Intent(this, AddNewCategoryActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick() {
        startActivity(new Intent(this,MenuCategoryActivity.class));
    }

    @Override
    public void onClickEdit() {
        startActivity(new Intent(this,AddNewCategoryActivity.class));
    }

    @Override
    public void onClickDelete() {
        Toast.makeText(this,"Deleted", Toast.LENGTH_LONG).show();
    }
}
