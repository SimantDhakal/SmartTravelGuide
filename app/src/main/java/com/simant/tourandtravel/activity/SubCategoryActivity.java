package com.simant.tourandtravel.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simant.tourandtravel.R;
import com.simant.tourandtravel.adapter.SubCategoryAdapter;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.SubCategoryModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryActivity extends AppCompatActivity {

    public static String id = null;
    RecyclerView recyclerView;
    TextView textView_topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        Bundle val = getIntent().getExtras();
        String _catId = val.getString("_id");
        String _name = val.getString("_name");

        textView_topic = findViewById(R.id.topic);
        textView_topic.setText("Nearby " + _name);
        
        recyclerView = findViewById(R.id.subCategory_recyclerView);
        getSubCat(_catId.toString());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void getSubCat(String _catId){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<SubCategoryModal>> modalClassCall = retrofitApiInterface.loadSubCategory(_catId);

        modalClassCall.enqueue(new Callback<List<SubCategoryModal>>() {
            @Override
            public void onResponse(Call<List<SubCategoryModal>> call, Response<List<SubCategoryModal>>
                    response) {

                System.out.println("Check " + response.body());

                SubCategoryAdapter recyclerviewAdapter = new SubCategoryAdapter
                        (getApplicationContext(),response.body());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(horizontalLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<SubCategoryModal>> call, Throwable t) {
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    
}