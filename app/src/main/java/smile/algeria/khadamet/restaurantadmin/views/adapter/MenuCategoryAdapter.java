package smile.algeria.khadamet.restaurantadmin.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.MenuCategoryItemLayoutBinding;
import smile.algeria.khadamet.restaurantadmin.databinding.MenuItemLayoutBinding;
import smile.algeria.khadamet.restaurantadmin.views.interfaces.IMenuHandler;

public class MenuCategoryAdapter extends RecyclerView.Adapter<MenuCategoryAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private IMenuHandler handler;
    public MenuCategoryAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
        handler = (IMenuHandler) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        MenuCategoryItemLayoutBinding binding=
                DataBindingUtil.inflate(layoutInflater, R.layout.menu_category_item_layout, parent, false);
        return new MyViewHolder(binding);
    }

    int images[] ={R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,
            R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,
            R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,
            R.drawable.food5,R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10
    };
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Picasso.get().load(images[position]).into(holder.binding.categoryItemImage);
        holder.binding.overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MenuCategoryItemLayoutBinding binding;
        public MyViewHolder(MenuCategoryItemLayoutBinding view) {
            super(view.getRoot());
            this.binding = view;

        }
    }


    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.category_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuCategoryAdapter.MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.edit:
                    handler.onClickEdit();
                    return true;
                case R.id.delete:
                    handler.onClickDelete();
                    return true;
                default:
            }
            return false;
        }
    }

}