package smile.algeria.khadamet.restaurantadmin.views.activity;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import smile.algeria.khadamet.restaurantadmin.ViewPagerAdapter;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IOrderNumberHandler;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IOrdersHandler;
import smile.algeria.khadamet.restaurantadmin.views.fragment.NewOrdersFragment;
import smile.algeria.khadamet.restaurantadmin.views.fragment.OnGoingOrdersFragment;
import smile.algeria.khadamet.restaurantadmin.views.fragment.PastOrdersFragment;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityOrderOnlineBinding;

import static smile.algeria.khadamet.restaurantadmin.data.Constants.VIEW_DETAILS_NEW_ORDERS;
import static smile.algeria.khadamet.restaurantadmin.data.Constants.VIEW_DETAILS_ONGOING_ORDERS;


public class OrderOnlineActivity extends AppCompatActivity implements IOrdersHandler, IOrderNumberHandler {

    private Toolbar toolbar;
    private ActivityOrderOnlineBinding binding;
    private TextView newBadge,progressBadge,completeBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_order_online);

        String[] titles = getResources().getStringArray(R.array.array_order);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupViewPager();
        binding.tabs.setupWithViewPager(binding.myViewpager);


        for (int i = 0; i < binding.tabs.getTabCount(); i++) {
            TabLayout.Tab tab = binding.tabs.getTabAt(i);
            tab.setCustomView(getTabView(binding.tabs,titles[i],i));
        }
    }

    public View getTabView(TabLayout tabLayout, String title,int index) {
        View view = LayoutInflater.from(this)
                .inflate(R.layout.tab_layout, tabLayout, false);
        TextView tab_title = view.findViewById(R.id.tab_title);

        tab_title.setText(title);

        if (index == 2){
            completeBadge = view.findViewById(R.id.cart_badge);
            completeBadge.setVisibility(View.GONE);
        }else if (index == 1){
            progressBadge = view.findViewById(R.id.cart_badge);
        }else {
            newBadge = view.findViewById(R.id.cart_badge);
        }


        return view;
    }


    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewOrdersFragment());
        adapter.addFragment(new OnGoingOrdersFragment());
        adapter.addFragment(new PastOrdersFragment());
        binding.myViewpager.setAdapter(adapter);



    }


    @Override
    public void onCallClicked(String number) {
        call(this,number);
    }

    @Override
    public void onViewDetailsClicked(String id,int type) {
        if (type == VIEW_DETAILS_NEW_ORDERS){
            startActivity(new Intent(this, NewOrderActivity.class));
        }else if (type == VIEW_DETAILS_ONGOING_ORDERS){
            startActivity(new Intent(this, OngoingOrderActivity.class));
        }else {
            startActivity(new Intent(this, PastOrderActivity.class));
        }
    }

    @Override
    public void onCancelClicked() {
    }

    @Override
    public void onAcceptClicked() {

    }

    @Override
    public void onDeliveryClicked() {
        startActivity(new Intent(this, DeliveryActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void newOrder(int number) {
        newBadge.setText(number+"");
    }

    @Override
    public void inProgressOrder(int number) {
        progressBadge.setText(number+"");
    }

    public static void call(Context context, String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
