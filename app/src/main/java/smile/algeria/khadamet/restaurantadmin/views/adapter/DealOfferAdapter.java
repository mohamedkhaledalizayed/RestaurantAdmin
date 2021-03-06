package smile.algeria.khadamet.restaurantadmin.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.DealOfferItemBinding;
import smile.algeria.khadamet.restaurantadmin.databinding.FeedBackItemBinding;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IDealItemHandler;

public class DealOfferAdapter  extends RecyclerView.Adapter<DealOfferAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private IDealItemHandler handler;
    public DealOfferAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
        handler = (IDealItemHandler)context;
    }

    @Override
    public DealOfferAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        DealOfferItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.deal_offer_item, parent, false);


        return new DealOfferAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final DealOfferAdapter.MyViewHolder holder, final int position) {
        holder.binding.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DealOfferItemBinding binding;
        public MyViewHolder(DealOfferItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}
