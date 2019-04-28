package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityMenuCategoryBinding;
import smile.algeria.khadamet.restaurantadmin.views.adapter.MenuAdapter;
import smile.algeria.khadamet.restaurantadmin.views.adapter.MenuCategoryAdapter;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IMenuHandler;

public class MenuCategoryActivity extends AppCompatActivity implements IMenuHandler {


    private ActivityMenuCategoryBinding binding;
    private MenuCategoryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_category);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chinese Food");
        mAdapter = new MenuCategoryAdapter(this,new ArrayList<String>());
        binding.menuCategoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.menuCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.menuCategoryRecycler.setAdapter(mAdapter);
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
        startActivity(new Intent(this,AddNewItemActivity.class));
    }

    @Override
    public void onClickDelete() {
        Toast.makeText(this,"Deleted", Toast.LENGTH_LONG).show();
    }
}
