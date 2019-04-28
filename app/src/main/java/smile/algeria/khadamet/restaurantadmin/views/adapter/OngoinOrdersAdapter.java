package smile.algeria.khadamet.restaurantadmin.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import smile.algeria.khadamet.restaurantadmin.views.interfaces.IOrderNumberHandler;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IOrdersHandler;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.OngoingOrderItemBinding;

import static smile.algeria.khadamet.restaurantadmin.data.Constants.VIEW_DETAILS_ONGOING_ORDERS;


public class OngoinOrdersAdapter extends RecyclerView.Adapter<OngoinOrdersAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private IOrdersHandler handler;
    private LayoutInflater layoutInflater;
    private IOrderNumberHandler numberHandler;
    public OngoinOrdersAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
        handler=(IOrdersHandler) context;
        numberHandler = (IOrderNumberHandler) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        OngoingOrderItemBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.ongoing_order_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        numberHandler.inProgressOrder(25);
        holder.binding.viewDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onViewDetailsClicked("",VIEW_DETAILS_ONGOING_ORDERS);
            }
        });

        holder.binding.callCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onCallClicked("123456789");
            }
        });

        holder.binding.deliveryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onDeliveryClicked();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public OngoingOrderItemBinding binding;

        public MyViewHolder(OngoingOrderItemBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }

}