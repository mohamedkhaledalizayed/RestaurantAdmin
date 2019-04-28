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

import smile.algeria.khadamet.restaurantadmin.views.adapter.PastOrdersAdapter;
import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.databinding.FragmentPastOrdersBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastOrdersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastOrdersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PastOrdersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastOrdersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastOrdersFragment newInstance(String param1, String param2) {
        PastOrdersFragment fragment = new PastOrdersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private PastOrdersAdapter mAdapter;
    private RecyclerView recyclerView;
    private FragmentPastOrdersBinding binding;
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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_past_orders, container, false);
        mAdapter = new PastOrdersAdapter(getActivity(),new ArrayList<String>());
        binding.pastOrdersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.pastOrdersRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.pastOrdersRecycler.setAdapter(mAdapter);
        return binding.getRoot();    }

}
