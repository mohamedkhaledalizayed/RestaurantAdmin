package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.ActivityDealOfferBinding;
import smile.algeria.khadamet.restaurantadmin.utils.AppUtils;
import smile.algeria.khadamet.restaurantadmin.views.adapter.DealOfferAdapter;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IDealItemHandler;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static android.support.v7.widget.helper.ItemTouchHelper.*;
public class DealOfferActivity extends AppCompatActivity implements IDealItemHandler {

    private ActivityDealOfferBinding binding;
    private DealOfferAdapter mAdapter;
    private SwipeController swipeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_deal_offer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.deal_offer);
        mAdapter = new DealOfferAdapter(this,new ArrayList<String>());
        binding.dealOfferRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.dealOfferRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.dealOfferRecycler.setAdapter(mAdapter);

        //https://docs.google.com/presentation/d/1sr1WQWupivlWqgyfp711uW6kU4lYt-6ruluHrEYlJk0/edit#slide=id.p12

//        swipeController = new SwipeController(new SwipeControllerActions() {
//            @Override
//            public void onRightClicked(int position) {
////                mAdapter.players.remove(position);
//                mAdapter.notifyItemRemoved(position);
//                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
//                Toast.makeText(DealOfferActivity.this, R.string.deleted, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onLeftClicked(int position) {
//                startActivity(new Intent(DealOfferActivity.this,AddOfferActivity.class));
//            }
//        });
//
//        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
//        itemTouchhelper.attachToRecyclerView(binding.dealOfferRecycler);
//
//
//        binding.dealOfferRecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                swipeController.onDraw(c);
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deal_offer_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }else if (item.getItemId() == R.id.add){
            startActivity(new Intent(this,AddOfferActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick() {
        AppUtils.dialog(DealOfferActivity.this,"Select Action...","","Edit","Delete");
    }
}