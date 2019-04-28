package smile.algeria.khadamet.restaurantadmin.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import smile.algeria.khadamet.restaurantadmin.views.interfaces.IOrdersHandler;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.PastOrdersItemBinding;

import static smile.algeria.khadamet.restaurantadmin.data.Constants.VIEW_DETAILS_PAST_ORDERS;

public class PastOrdersAdapter extends RecyclerView.Adapter<PastOrdersAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private IOrdersHandler handler;
    public PastOrdersAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
        handler=(IOrdersHandler) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        PastOrdersItemBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.past_orders_item, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.viewDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.onViewDetailsClicked("",VIEW_DETAILS_PAST_ORDERS);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public PastOrdersItemBinding binding;
        public MyViewHolder(PastOrdersItemBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }

}