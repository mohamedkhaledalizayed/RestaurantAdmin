package smile.algeria.khadamet.restaurantadmin.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import smile.algeria.khadamet.restaurantadmin.R;


public class SupportChatAdapter extends RecyclerView.Adapter<SupportChatAdapter.MyViewHolder> {

    private List<String> prices;
    private Context context;
    private int indecator;
    private String photo="";
    public SupportChatAdapter(Context context, List<String> prices) {
        this.prices = prices;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=null;
        if (viewType==1){
            itemView= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_1, parent, false);
        }else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_2, parent, false);
        }

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2!=0){
            indecator=1;
            return 1;
        }
        indecator=0;
        return 0;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView content,msg_time;
        public LinearLayout layout;
        public CircleImageView imageView;

        public MyViewHolder(View view) {
            super(view);

        }
    }

    public int getLastitemPosition() {
        return prices.size() - 1;
    }

}