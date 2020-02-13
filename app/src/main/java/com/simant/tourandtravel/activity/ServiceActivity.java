package com.simant.tourandtravel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.simant.tourandtravel.MainActivity;
import com.simant.tourandtravel.R;
import com.simant.tourandtravel.adapter.ProductAdapter;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.ProductModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivity extends AppCompatActivity {

    RecyclerView recyclerView_product;
    public static String id = null;

    private SensorManager sensorManager;
    TextView tvaccdis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView_product = findViewById(R.id.product_recyclerView);
        getProduct(id.toString());

        // accelerometer code
        tvaccdis = findViewById(R.id.tvaccdis);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        final Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                String xAxis = "x:" + values[0];
                String yAxis = "y:" + values[1];
                String zAxis = "z:" + values[2];

                if (values[0] > 5) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                tvaccdis.setText(xAxis + " " + yAxis + " " + zAxis);
            }
        };
        if (sensor != null) {
            sensorManager.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(getApplicationContext(), "No sensor Found", Toast.LENGTH_SHORT).show();
        }

    }

    public void getProduct(String product){
        Interface retrofitApiInterface = BaseURL.getInstance().create(Interface.class);
        Call<List<ProductModal>> modalClassCall = retrofitApiInterface.loadProductUnlimit(product);

        modalClassCall.enqueue(new Callback<List<ProductModal>>() {
            @Override
            public void onResponse(Call<List<ProductModal>> call, Response<List<ProductModal>>
                    response) {
                System.out.println("Review " + response.body());
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