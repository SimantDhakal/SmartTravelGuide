package com.simant.tourandtravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.simant.tourandtravel.R;
import com.simant.tourandtravel.adapter.ProductAdapter;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.ProductModal;
import com.simant.tourandtravel.modal.ProductModal;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSubCategoryActivity extends AppCompatActivity {

    TextView textView_name, textView_desc;
    RecyclerView recyclerView_product;
    public static String id = null;
    TextView textView_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sub_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView_product = findViewById(R.id.product_recyclerView);
        textView_view = findViewById(R.id.service);

        textView_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
            }
        });

        Bundle val = getIntent().getExtras();
        String _name = val.getString("_name");
        String _desc = val.getString("_desc");

        textView_name = findViewById(R.id.name);
        textView_desc = findViewById(R.id.desc);

        textView_name.setText(_name);
        textView_desc.setText(_desc);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getProduct(id.toString());
    }

    public void getProduct(String product){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<ProductModal>> modalClassCall = retrofitApiInterface.loadProduct(product);

        modalClassCall.enqueue(new Callback<List<ProductModal>>() {
            @Override
            public void onResponse(Call<List<ProductModal>> call, Response<List<ProductModal>>
                    response) {
                ProductAdapter recyclerviewAdapter = new ProductAdapter
                        (getApplicationContext(),response.body());
                LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL, false);
                recyclerView_product.setLayoutManager(horizontalLayoutManager);
                recyclerView_product.setHasFixedSize(true);
                recyclerView_product.setItemAnimator(new DefaultItemAnimator());
                recyclerView_product.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<ProductModal>> call, Throwable t) {
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
