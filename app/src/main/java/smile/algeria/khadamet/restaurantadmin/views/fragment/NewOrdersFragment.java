package smile.algeria.khadamet.restaurantadmin.views.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.views.adapter.NewOrdersAdapter;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.FragmentNewOrdersBinding;


public class NewOrdersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private FragmentNewOrdersBinding binding;
    public NewOrdersFragment() {
        // Required empty public constructor
    }


    public static NewOrdersFragment newInstance(String param1, String param2) {
        NewOrdersFragment fragment = new NewOrdersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private NewOrdersAdapter mAdapter;
    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_orders, container, false);
        mAdapter = new NewOrdersAdapter(getActivity(),new ArrayList<String>());
        binding.newOrdersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.newOrdersRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.newOrdersRecycler.setAdapter(mAdapter);


        //https://codeburst.io/android-swipe-menu-with-recyclerview-8f28a235ff28
        //https://www.google.com/search?q=how+to+swipe+item+in+recycler+view+in+android&oq=how+to+swipe+item+in+recycler+view+in+android&aqs=chrome..69i57.17014j0j7&sourceid=chrome&ie=UTF-8

        return binding.getRoot();
    }



}
