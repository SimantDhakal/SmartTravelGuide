package com.simant.tourandtravel.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simant.tourandtravel.R;
import com.simant.tourandtravel.adapter.CategoryAdapter;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.CategoryModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView_category;
    

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView_category = view.findViewById(R.id.category_recylerView);

        getCategory();

        return view;
    }

    public void getCategory(){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<CategoryModal>> productModalCall = retrofitApiInterface.getCategory();
        productModalCall.enqueue(new Callback<List<CategoryModal>>() {
            @Override
            public void onResponse(Call<List<CategoryModal>> call, Response<List<CategoryModal>> response) {
                CategoryAdapter recyclerviewAdapter = new CategoryAdapter(getActivity(),response.body());
                RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getContext(), 4);
                recyclerView_category.setLayoutManager(mlayoutManager);
                recyclerView_category.setHasFixedSize(true);
                recyclerView_category.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<CategoryModal>> call, Throwable t) {

            }
        });
    }

}
